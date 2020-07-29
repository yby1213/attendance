package com.etc.service;

import java.util.List;

import com.etc.entity.User;

public interface UserService {
	/**
	 * 新增员工
	 * @param user
	 * @return
	 */
	int AddUser(User user);
	/**
	 * 删除员工
	 * @param userId
	 * @return
	 */
	int DelUser(int userId);
	/**
	 * 列出所有员工
	 * @return
	 */
	List<User> AllUser();
	/**
	 * 列出部分员工
	 * @param userName
	 * @return
	 */
	List<User> ListUser(int userId);
	/**
	 * 更改工资
	 * @param user
	 * @return
	 */
	int UpdNum(User user);
}
