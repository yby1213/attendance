package com.etc.entity;

public class Login {
	private String loginId;
	private String loginPwd;
	private int userId;
	public Login(String loginId, String loginPwd, int userId) {
		super();
		this.loginId = loginId;
		this.loginPwd = loginPwd;
		this.userId = userId;
	}
	public Login() {
		super();
	}
	
	public Login(String loginPwd, int userId) {
		super();
		this.loginPwd = loginPwd;
		this.userId = userId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", loginPwd=" + loginPwd + ", userId=" + userId + "]";
	}
	
	

}
