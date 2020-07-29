package com.etc.service.impl;

import java.util.List;

import com.etc.dao.ClockMessDao;
import com.etc.dao.impl.ClockMessDaoImpl;
import com.etc.entity.ClockMess;
import com.etc.service.ClockMessService;

public class ClockMessServiceImpl implements ClockMessService {
	
	private ClockMessDao cmd = new ClockMessDaoImpl();
	
	/**
	 * 老板查询所有打卡信息
	 */
	@Override
	public List<ClockMess> getAllClockMess() {
		List<ClockMess> list = cmd.getAllClockMess();
		return list;
	}
	
	/**
	 * 老板修改员工打卡时间
	 */
	@Override
	public int updateClockMess(ClockMess cm) {
		int result = cmd.updateClockMess(cm);
		return result;
	}
	

}
