package com.etc.service.impl;

import java.util.List;

import com.etc.dao.LoginDao;
import com.etc.dao.impl.LoginDaoImpl;
import com.etc.entity.Login;
import com.etc.service.LoginService;

public class LoginServiceImpl implements LoginService {
	LoginDao ld=new LoginDaoImpl();

	@Override
	public int AddLogin(Login login) {
		// TODO Auto-generated method stub
		return ld.AddLogin(login);
	}

	@Override
	public int DelLogin(int userId) {
		// TODO Auto-generated method stub
		return ld.DelLogin(userId);
	}

	@Override
	public List<Login> GetLoginById(int userId) {
		// TODO Auto-generated method stub
		return ld.GetLoginById(userId);
	}

	@Override
	public int UpdLogin(Login login) {
		// TODO Auto-generated method stub
		return ld.UpdLogin(login);
	}

	@Override
	public List<Login> ListLogin() {
		// TODO Auto-generated method stub
		return ld.ListLogin();
	}

	@Override
	public Login loginUser(String loginId, String loginPwd) {
		// TODO Auto-generated method stub
		return ld.loginUser(loginId, loginPwd);
	}

	@Override
	public List<Login> QueryLoginId(Login login) {
		// TODO Auto-generated method stub
		return ld.QueryLoginId(login);
	}


}
