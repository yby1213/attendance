package com.etc.entity;

import java.sql.Timestamp;
/**
 * 打开信息实体类
 * @author yby
 *
 */
public class Clock {
	private int userId;
	private Timestamp signIn;
	private Timestamp signOut;
	public Clock(int userId, Timestamp signIn, Timestamp signOut) {
		super();
		this.userId = userId;
		this.signIn = signIn;
		this.signOut = signOut;
	}
	public Clock() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Timestamp getSignIn() {
		return signIn;
	}
	public void setSignIn(Timestamp signIn) {
		this.signIn = signIn;
	}
	public Timestamp getSignOut() {
		return signOut;
	}
	public void setSignOut(Timestamp signOut) {
		this.signOut = signOut;
	}
	@Override
	public String toString() {
		return "Clock [userId=" + userId + ", signIn=" + signIn + ", signOut=" + signOut + "]";
	}
	
	
}
