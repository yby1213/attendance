package com.etc.dao.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.etc.dao.ClockMessDao;
import com.etc.entity.ClockMess;
import com.etc.until.DBUtil;


public class ClockMessDaoImpl implements ClockMessDao {
	
	/**
	 * 老板查询所有打卡信息
	 */
	@Override
	public List<ClockMess> getAllClockMess() {
		String sql = "select id \"id\", userId \"userId\", signOut \"signOut\"\r\n" + 
				"     from clockmess  ";
		List<ClockMess> list = (List<ClockMess>)DBUtil.select(sql, ClockMess.class);
		//若查询数据为空
		if(list.size() == 0) {
			return null;
		}
		return list;
	}
	
	/**
	 * 老板修改员工打卡时间
	 */
	@Override
	public int updateClockMess(ClockMess cm) {
		String sql = "update clockmess set signout = ? where id  =?";
		
		int result = DBUtil.execute(sql, cm.getSignOut(),cm.getId());
		return result;
		
	}
	
	/**
	 * 分页查询
	 */
	@Override
	public List<ClockMess> page(int pageIndex, int pageSize) {
		String sql = "select id \"id\", userId \"userId\", signOut \"signOut\"\r\n" + 
				"     from (select rownum as myrow, clockmess.* from clockmess)  "+
				"where myrow > ? and myrow <= ?";
		List<ClockMess> list = (List<ClockMess>)DBUtil.select(sql, ClockMess.class, (pageIndex-1)*pageSize, pageIndex*pageSize);
		return list;
	}
	


		@Override
		public int countAll() {
			String sql = "select count(*) from clockmess";
			int result = Integer.valueOf(DBUtil.getFirst(sql).toString());
			//这两个都行！
			int result2 = ((BigDecimal)DBUtil.getFirst(sql)).intValue();
			return result2;
		}
		//测试
		public static void main(String[] args) {
			//查询
			ClockMessDao cmd = new ClockMessDaoImpl();
			//时间格式转化
//			Timestamp signIn = Timestamp.valueOf("2020-06-16 00:00:00.0");
//			Timestamp signOut = Timestamp.valueOf("2020-06-20 12:00:00.0");
//			cmd.updateClockMess(new ClockMess(1,0,signOut));
			
//			List<ClockMess> list = cmd.page(1,5);
//			System.out.println(list);
			
			int countAll = cmd.countAll();
			System.out.println(countAll);
		}

}
