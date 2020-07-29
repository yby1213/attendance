package com.etc.service;

import java.util.List;

import com.etc.entity.Login;

public interface LoginService {
	//查询账户
	List<Login> ListLogin();
	//添加账户
	int AddLogin(Login login);
	//删除账户
	int DelLogin(int userId);
	//根据主键查询对应信息
	List<Login> GetLoginById(int userId);
	
	//修改方法
	int UpdLogin(Login login);
	

	//用户登录验证 
	Login loginUser(String loginId,String loginPwd);

	//判断账号是否存在
	List<Login> QueryLoginId(Login login);
}
