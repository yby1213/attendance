package com.etc.service.impl;

import java.util.List;

import com.etc.dao.MessageDao;
import com.etc.dao.impl.MessageDaoImpl;
import com.etc.entity.Message;
import com.etc.service.MessageService;

public class MessageServiceImpl implements MessageService {
	private MessageDao md = new MessageDaoImpl();
	/**
	 * 查询特殊信息（feedBack为空）
	 */
	@Override
	public List<Message> getUncheckedMessage() {
		List<Message> list = md.getUncheckedMessage();
		return list;
	}
	/**
	 * 老板添加是/否
	 */
	@Override
	public int setYorN(int id, String feedBack) {
		int result = md.setYorN(id, feedBack);
		return result;
	}
	
	/**
	 * 员工查询自己的全部特殊信息
	 */
	@Override
	public List<Message> getAllMessage(int userId) {
		List<Message> list = md.getAllMessage(userId);
		return list;
	}
	
	/**
	 * 员工填写特殊信息
	 */
	@Override
	public int insertMessage(Message message) {
		int result = md.insertMessage(message);
		return result;
	}

}
