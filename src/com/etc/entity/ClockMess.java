package com.etc.entity;

import java.sql.Timestamp;

public class ClockMess {
	private int id;
	private int userId;
	private Timestamp signOut;
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
	public Timestamp getSignOut() {
		return signOut;
	}
	public void setSignOut(Timestamp signOut) {
		this.signOut = signOut;
	}
	public ClockMess(int id, int userId, Timestamp signOut) {
		super();
		this.id = id;
		this.userId = userId;
		this.signOut = signOut;
	}
	public ClockMess() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ClockMess [id=" + id + ", userId=" + userId + ", signOut=" + signOut + "]";
	}
	
	
}
