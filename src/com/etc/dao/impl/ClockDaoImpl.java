package com.etc.dao.impl;



import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import com.etc.dao.ClockDao;
import com.etc.entity.Clock;
import com.etc.until.DBUtil;

public class ClockDaoImpl implements ClockDao {

	@Override
	public int AddClock(Clock clock) {
		// TODO Auto-generated method stub
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH");
		int hour = Integer.parseInt(sdf.format(today));
		if(hour>=6&&hour<=9) {
			String sql="insert into clockmess(id,userId,signout) values(SEQ_CLOCKMESS_ID.nextval,?,sysdate)";
			String sql2 = "UPDATE users SET CLOCKNUM=CLOCKNUM+1 WHERE userid=?";
			DBUtil.execute(sql2, clock.getUserId());
			int result = DBUtil.execute(sql, clock.getUserId());
			int a =0;
			return result;
		}else if(hour>=10&&hour<=19) {
			String sql="insert into clockmess(id,userId,SIGNOUT) values(SEQ_CLOCKMESS_ID.nextval,?,sysdate)";
			String sql2 = "UPDATE users SET CLOCKNUM=CLOCKNUM+1 WHERE userid=?";
			DBUtil.execute(sql2, clock.getUserId());
			int result = DBUtil.execute(sql, clock.getUserId());
			int a = 0;
			return result;
			
		}
		return 0;
	}
	

}
