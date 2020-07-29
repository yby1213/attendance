package com.etc.dao.impl;

import java.util.List;

import com.etc.entity.Message;
import com.etc.dao.MessageDao;
import com.etc.until.DBUtil;

public class MessageDaoImpl implements MessageDao {
	//测试
		public static void main(String[] args) {
			
			//特殊信息查询测试（feedBack为空）
			MessageDao ms = new MessageDaoImpl();
			
		    List<Message> list = ms.getUncheckedMessage(); 
		    System.out.println(list);
			 
			
			//插入
//			ms.insertMessage(new Message(0,2,"sss",null,null,null));
			
		}
		
	/**
	 * 查询特殊信息（feedBack为空）
	 */
	@Override
	public List<Message> getUncheckedMessage() {
		String sql = "select id \"id\", userId \"userId\", userMessage \"userMessage\",\r\n" + 
				"          time \"time\", feedBack \"feedBack\", kind \"kind\" \r\n" + 
				"          from message\r\n" + 
				"          where feedBack is null" +
				"          order by time desc";
		
		List<Message> list = (List<Message>)DBUtil.select(sql, Message.class);
		//若查询数据为空
		if(list.size() == 0) {
			return null;
		}
		return list;
	}
	
	/**
	 * 老板添加是/否
	 */
	@Override
	public int setYorN(int id, String feedBack) {
		String sql = "update message set feedBack = ? where id = ?";
		int result = DBUtil.execute(sql, feedBack, id);
		return result;
	}

	/**
	 * 员工查询自己的全部特殊信息
	 */
	@Override
	public List<Message> getAllMessage(int userId) {
		String sql = "select id \"id\", userId \"userId\", userMessage \"userMessage\",\r\n" + 
				"          time \"time\", feedBack \"feedBack\", kind \"kind\" \r\n" + 
				"          from message\r\n" + 
				"          where userId = ?" +
				"          order by time desc";
		List<Message> list = (List<Message>)DBUtil.select(sql, Message.class, userId);
		//若查询数据为空
		if(list.size() == 0) {
			return null;
		}
		return list;
	}

	/**
	 * 员工填写特殊信息
	 */
	@Override
	public int insertMessage(Message message) {
		String sql = "insert into message(id, userId, userMessage, time, feedBack, kind)\r\n" + 
				"        values(seq_message_id.nextval,?,?,sysdate,null,?)";
		int result = DBUtil.execute(sql, message.getUserId(), message.getUserMessage(), message.getKind());
		return result;
	}
	
	
	

}
