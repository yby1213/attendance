package com.etc.service.impl;

import com.etc.dao.ClockDao;
import com.etc.dao.impl.ClockDaoImpl;
import com.etc.entity.Clock;
import com.etc.service.ClockService;

public class ClockServiceImpl implements ClockService {
	private ClockDao cd = new ClockDaoImpl();
	@Override
	public int AddClock(Clock clock) {
		// TODO Auto-generated method stub
		return cd.AddClock(clock);
	}

}
