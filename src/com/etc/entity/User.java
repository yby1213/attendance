package com.etc.entity;

import java.sql.Timestamp;

/**
 * 员工表实体类
 * @author yby
 *
 */
public class User {
	private int userId;
	private String userName;
	private String userPost;//员工职位
	private Timestamp  entry_time;//入职时间
	private int clockNum;//打卡次数
	private String userMessage;//特殊信息
	private int userSal;//工资
	public User(int userId, String userName, String userPost, Timestamp entry_time, int clockNum, String userMessage,
			int userSal) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPost = userPost;
		this.entry_time = entry_time;
		this.clockNum = clockNum;
		this.userMessage = userMessage;
		this.userSal = userSal;
	}
	
	public User(String userName, int clockNum) {
		super();
		this.userName = userName;
		this.clockNum = clockNum;
	}

	public User() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPost() {
		return userPost;
	}
	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}
	public Timestamp getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Timestamp entry_time) {
		this.entry_time = entry_time;
	}
	public int getClockNum() {
		return clockNum;
	}
	public void setClockNum(int clockNum) {
		this.clockNum = clockNum;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public int getUserSal() {
		return userSal;
	}
	public void setUserSal(int userSal) {
		this.userSal = userSal;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPost=" + userPost + ", entry_time="
				+ entry_time + ", clockNum=" + clockNum + ", userMessage=" + userMessage + ", userSal=" + userSal + "]";
	}
	
}
