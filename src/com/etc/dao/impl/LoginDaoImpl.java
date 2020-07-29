package com.etc.dao.impl;

import java.util.List;

import com.etc.dao.LoginDao;
import com.etc.entity.Login;
import com.etc.service.LoginService;
import com.etc.service.impl.LoginServiceImpl;
import com.etc.until.DBUtil;



public class LoginDaoImpl implements LoginDao {

	/**
	 * 判断账号是否存在
	 */
	@Override
	public List<Login> QueryLoginId(Login login) {
		String sql="select LOGINID \"loginId\" from login where LOGINID=?";
		List<Login> list= (List<Login>) DBUtil.select(sql, Login.class,login.getLoginId());
		if(list.size()==0) {
			return null;
		}
			return list;
	}
	
	@Override
	public List<Login> ListLogin() {
		String sql="SELECT LOGINID \"loginId\",LOGINPWD \"loginPwd\",USERID \"userId\" FROM LOGIN";
		List<Login> list= (List<Login>) DBUtil.select(sql, Login.class);
		return list;
	}
	/**
	 * 添加用户
	 */
	@Override
	public int AddLogin(Login login) {
		String sql="INSERT INTO LOGIN VALUES(?,?,?)";
		int result=DBUtil.execute(sql,login.getLoginId(),login.getLoginPwd(),login.getUserId());
		return result;
	}

	@Override
	public int DelLogin(int userId) {
		String sql="DELETE FROM USERS WHERE USERID=?";
		int result=DBUtil.execute(sql,userId);
		return result;
	}
	/**
	 * 通过ID查找用户信息
	 */
	@Override
	public List<Login> GetLoginById(int userId) {
		String sql="SELECT LOGINID \"loginId\",LOGINPWD \"loginPwd\",USERID \"userId\" FROM LOGIN WHERE USERID=?";
		List<Login> list= (List<Login>) DBUtil.select(sql, Login.class,userId);
		
		if(list.size()==0) {
			return null;
		}
			return list;
	}

	@Override
	public int UpdLogin(Login login) {
		String sql="UPDATE LOGIN SET LOGINID=?,LOGINPWD=? where USERID=?";
		int result=DBUtil.execute(sql, login.getLoginId(),login.getLoginPwd(),login.getUserId());
		
		return result;
	}

	/**
	 * 用户登录验证
	 */
	@Override
	public Login loginUser(String loginId, String loginPwd) {
		String sql="SELECT LOGINID \"loginId\",LOGINPWD \"loginPwd\",USERID \"userId\" FROM LOGIN WHERE LOGINID=? AND LOGINPWD=?";
		List<Login> list= (List<Login>) DBUtil.select(sql, Login.class,loginId,loginPwd);
		if(list.size()==0) {
			return null;
		}else {
			return list.get(0);
		}
	}



}
