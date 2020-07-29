package com.etc.service;

import java.util.List;

import com.etc.entity.ClockMess;

public interface ClockMessService {
	/**
	 * 老板查询所有打卡信息
	 */
	List<ClockMess> getAllClockMess();
	
	/**
	 * 老板修改员工打卡时间
	 */
	int updateClockMess(ClockMess cm);
}
