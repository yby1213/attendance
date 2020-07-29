package com.etc.dao;

import com.etc.entity.Clock;

public interface ClockDao {
	/**
	 * 早上和晚上打卡实现
	 * @param clock
	 * @return
	 */
	int AddClock(Clock clock);

}
