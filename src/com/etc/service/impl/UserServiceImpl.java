package com.etc.service.impl;

import java.util.List;

import com.etc.dao.UserDao;
import com.etc.dao.impl.UserDaoImpl;
import com.etc.entity.User;
import com.etc.service.UserService;


public class UserServiceImpl implements UserService {
	private UserDao ud = new UserDaoImpl();
	@Override
	public int AddUser(User user) {
		// TODO Auto-generated method stub
		return ud.AddUser(user);
	}
	@Override
	public int DelUser(int userId) {
		// TODO Auto-generated method stub
		return ud.DelUser(userId);
	}
	@Override
	public List<User> AllUser() {
		// TODO Auto-generated method stub
		return ud.AllUser();
	}
	@Override
	public int UpdNum(User user) {
		// TODO Auto-generated method stub
		return ud.UpdNum(user);
	}
	@Override
	public List<User> ListUser(int userId) {
		// TODO Auto-generated method stub
		return ud.ListUser(userId);
	}

}
