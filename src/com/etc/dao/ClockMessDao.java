package com.etc.dao;

import java.math.BigDecimal;
import java.util.List;

import com.etc.entity.ClockMess;


public interface ClockMessDao {
	/**
	 * 老板查询所有打卡信息
	 */
	List<ClockMess> getAllClockMess();
	
	/**
	 * 老板修改员工打卡时间
	 */
	int updateClockMess(ClockMess cm);
	
	/**
	 * 分页查询
	 */
	List<ClockMess> page(int pageIndex,int pageSize);
	
	
	int countAll();
}
