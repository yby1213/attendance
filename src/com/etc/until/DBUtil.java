package com.etc.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 数据库操作的辅助类
 */
public class DBUtil {

	//useunicode=true&characterEncoding=utf-8 使用unicode编码，同时字符编码格式为utf-8
	//goodsdb 改成自己的数据库
	
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; 
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER  = "SCOTT";
	private static final String PASSWORD = "tiger";
	/**
	 * 获取连接对象
	 * 
	 * @return 连接对象
	 */
	public static Connection getConn() {

		Connection conn = null;
		try {

			Class.forName(DRIVER);
			// 得到连接对象
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (Exception e) {
			throw new RuntimeException("数据库连接失败!", e);
		}
		return conn;
	}

	/**
	 * 释放资源
	 * 
	 * @param rs
	 *            结果集
	 * @param pstmt
	 *            命令处理对象
	 * @param conn
	 *            连接对象
	 */
	public static void close(ResultSet rs, PreparedStatement pstmt,
			Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException("释放资源失败!", e);
		}
	}

	/**
	 * 设置参数
	 * 
	 * @param sql
	 * @param conn
	 * @param pstmt
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	private static PreparedStatement setPstmt(String sql, Connection conn,
			PreparedStatement pstmt, Object... param) throws SQLException {
		pstmt = conn.prepareStatement(sql);
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				pstmt.setObject(i + 1, param[i]);
			}
		}
		return pstmt;
	}

	/**
	 * 通用的数据库(增,删,改)操作方法
	 * 
	 * @param sql
	 *            sql语句
	 * @param param
	 *            sql语句参数
	 * @return 受影响行数
	 */
	public static int execute(String sql, Object... param) {
		Connection conn = getConn();
		try {
			return execute(sql, conn, param);
		} finally {
			close(null, null, conn);
		}
	}

	/**
	 * 通用的增删改操作(事务访问)
	 * 
	 * @param sql
	 * @param conn
	 * @param param
	 * @return
	 */
	public static int execute(String sql, Connection conn, Object... param) {
		PreparedStatement pstmt = null;
		try {
			pstmt = setPstmt(sql, conn, pstmt, param);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			//这里最好得到异常信息
			e.printStackTrace();
			throw new RuntimeException("数据库操作失败!", e);
		} finally {
			close(null, pstmt, null);
		}
	}

	/**
	 * 通用查询方法
	 * 
	 * @param sql  要查询的sql语句
	 * @param cla  Class对象
	 * @param param  参数
	 * @return
	 */
	public static Object select(String sql, Class cla, Object... param) {
		Connection conn = getConn();
		try {
			return select(sql, conn, cla, param);
		} finally {
			close(null, null, conn);
		}
	}

	/**
	 * 带事务的查询方法
	 * 
	 * @param sql
	 * @param conn
	 * @param cla
	 * @param param
	 * @return
	 */
	public static Object select(String sql, Connection conn, Class cla,
			Object... param) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Object> list = new ArrayList<Object>();
		try {
			pstmt = setPstmt(sql, conn, pstmt, param);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// ?rs 结果集 cla Class对象
				//object其实就是数据表结构对应的一条实体记录,object就是那个实体类对象
				//这个方法convert是将结果集和cla对象进行转换
				Object object = convert(rs, cla); //Employee.class Goods.class Student.class
				list.add(object);
			}
			return list;
			
		} catch (SQLException e) {
			throw new RuntimeException("数据库查询失败!", e);
		} finally {
			close(rs, pstmt, null);
		}
	}

	/**
	 * 获取单个记录值,是单个记录注意,类似count(1)
	 * 
	 * @param sql
	 * @param param
	 * @return
	 */
	public static Object getFirst(String sql, Object... param) {
		Connection conn = getConn();
		try {
			return getFirst(sql, conn, param);
		} finally {
			close(null, null, conn);
		}
	}

	/**
	 * 获取单个记录 事务
	 * 
	 * @param sql
	 * @param conn
	 * @param param
	 * @return
	 */
	public static Object getFirst(String sql, Connection conn, Object... param) {
		List list = (List) select(sql, conn, Object.class, param);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * 事务处理操作
	 * 
	 * @param tran
	 * @return
	 */
	public static Object transaction(ITransaction tran) {
		Connection conn = getConn();
		try {
			conn.setAutoCommit(false);
			Object obj = tran.execute(conn);
			conn.commit();
			return obj;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException("回滚失败!", e);
			}
			throw new RuntimeException("事务执行失败", e);
		} finally {
			close(null, null, conn);
		}
	}

	/**
	 * 查询结果的转换(关系数据库 <=>java中类面向对象)
	 * 
	 * @param rs 结果集合
	 * @param cla  Class类对象
	 * @return
	 */
	public static Object convert(ResultSet rs, Class cla) {
		try {
			//getName 类名 包含了完整包结构类名
			if (cla.getName().equals("java.lang.Object")) {
				return rs.getObject(1);
			}
			// 创建实体类的实例 Class类对象的方法，创建指定对象的实例
			// new Goods();  new News();  new person();  new Users();
			//newInstance 会调用实体类的 无参数的构造
			Object object = cla.newInstance(); 
			//// 结果集头信息对象
			//rs.getMetaData() 获取此 ResultSet 对象的列的编号、类型和属性。
			///
			ResultSetMetaData metaData = rs.getMetaData();
			// 循环为实体类的实例的属性赋值 getColumnCount得到列的个数
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				// 获取列名  name
				String name = metaData.getColumnLabel(i);
				//System.out.println("resultSet column的列名 ："+name);
				//// 所有要注意：列名[查询语句中列名]与属性名必须一致。最好遵循骆驼命名方法.  rs.getObject(i) 结果集中的查询结果和对象匹配
				// select empNo as eNo,empName as eName from employee
				// setPO...(emplye,"esssss","001")
				BeanUtils.setProperty(object, name, rs.getObject(i));
			}
			return object;
		} catch (Exception e) {
			throw new RuntimeException("属性设置失败!", e);
		}
	}

	/**
	 * 分页操作 mysql;
	 * 
	 * @param sql
	 * @param page
	 * @param pageSize
	 * @param cla
	 * @param param
	 * @return
	 */
	public PageData getPage(String sql, Integer page, Integer pageSize,
			Class cla, Object... param) {
		String selSql = "select count(1) from (" + sql + ") t";
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = 20;
		}
		Integer count = Integer.parseInt(getFirst(selSql, param).toString());
		int start = (page - 1) * pageSize;
		selSql = sql + " limit " + start + "," + pageSize;
		List list = (List) select(sql, cla, param);
		PageData data = new PageData(list, count, pageSize, page);
		return data;
	}

	/**
	 * 分页操作 sqlserver
	 * 
	 * @param page
	 * @param pageSize
	 * @param cla
	 * @param identity
	 * @return
	 */
	public static PageData getPage(Integer page, Integer pageSize, Class cla,
			String identity) {
		String name = cla.getName().substring(
				cla.getName().lastIndexOf(".") + 1);// 根据命名规则从类名获取数据库表名
		String selSql = "select count(*) from " + name;// 获取总数
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = 20;
		}
		int start = (page - 1) * pageSize;
		Integer count = Integer.parseInt(getFirst(selSql, null).toString());
		selSql = "select top " + pageSize + " * from " + name + " where "
				+ identity + " not in (select top " + start + " " + identity
				+ " from " + name + " )"; // 拼接查询语句
		List list = (List) select(selSql, cla, null);
		PageData data = new PageData(list, count, pageSize, page);
		return data;
	}

}
