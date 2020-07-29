package com.etc.entity;

import java.sql.Timestamp;

public class Message {
	private int id;
	private int userId;
	private String userMessage;
	private Timestamp time;
	private String feedBack;
	private String kind;
	@Override
	public String toString() {
		return "Message [id=" + id + ", userId=" + userId + ", userMessage=" + userMessage + ", time=" + time
				+ ", feedBack=" + feedBack + ", kind=" + kind + "]";
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(int id, int userId, String userMessage, Timestamp time, String feedBack, String kind) {
		super();
		this.id = id;
		this.userId = userId;
		this.userMessage = userMessage;
		this.time = time;
		this.feedBack = feedBack;
		this.kind = kind;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getFeedBack() {
		return feedBack;
	}
	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
}
