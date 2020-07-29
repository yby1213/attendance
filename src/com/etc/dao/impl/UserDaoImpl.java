package com.etc.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import com.etc.dao.UserDao;
import com.etc.entity.User;
import com.etc.until.DBUtil;


public class UserDaoImpl implements UserDao {
	/**
	 * 新增员工
	 */
	@Override
	public int AddUser(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into users(userId,userName,userPost,entry_time,userSal) values(seq_id.nextval,?,?,sysdate,?)";
		int result = DBUtil.execute(sql, user.getUserName(),user.getUserPost(),user.getUserSal());
		return result;
	}

	/**
	 * 删除员工
	 */
	@Override
	public int DelUser(int userId) {
		// TODO Auto-generated method stub
		String sql = "delete from users where userid=?";
		String sql2 = "delete from login where userid=?";
		int result = DBUtil.execute(sql, userId);
		DBUtil.execute(sql2, userId);
		return result;
	}
	/**
	 * 列出所有员工
	 */
	@Override
	public List<User> AllUser() {
		// TODO Auto-generated method stub
		String sql = "SELECT USERID \"userId\" ,username \"userName\",USERPOST \"userPost\",ENTRY_TIME \"entry_time\",CLOCKNUM \"clockNum\",USERSAL \"userSal\" FROM users order by userid";
		List<User> list = (List<User>)DBUtil.select(sql,User.class);
		return list;
	}
	/**
	 * 列出部分员工，根据姓名
	 */
	@Override
	public List<User> ListUser(int userId) {
		// TODO Auto-generated method stub
		String sql = "SELECT USERID \"userId\" ,username \"userName\",USERPOST \"userPost\",ENTRY_TIME \"entry_time\",CLOCKNUM \"clockNum\",USERSAL \"userSal\" FROM users where userId=?";
		List<User> list = (List<User>)DBUtil.select(sql, User.class,userId);
		if(list.size() == 0) {
			return null;
		}
		return list;
	}
	/**
	 * 更改工资
	 */
	@Override
	public int UpdNum(User user) {
		// TODO Auto-generated method stub
		int result=0;
		String sql = "UPDATE users SET userpost=?,userSal=? WHERE userid=?";
		result = DBUtil.execute(sql, user.getUserPost(),user.getUserSal(),user.getUserId());
		int a = 0;
		return result;
	
	}
	public static void main(String[] args) {
		UserDaoImpl ud = new UserDaoImpl();
		int result = ud.UpdNum(new User(138,"","jj",null,0,"",5000));
		System.out.println(result);
		
	}

}
