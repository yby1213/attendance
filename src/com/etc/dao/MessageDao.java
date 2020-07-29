package com.etc.dao;

import java.util.List;

import com.etc.entity.Message;

public interface MessageDao {
	/**
	 * 查询特殊信息（feedBack为空）
	 */
	List<Message> getUncheckedMessage();
	/**
	 * 老板添加是/否
	 */
	int setYorN(int id, String feedBack);
	
	
	
	/**
	 * 员工查询自己的全部特殊信息
	 */
	List<Message> getAllMessage(int userId);
	
	
	/**
	 * 员工填写特殊信息
	 */
	int insertMessage(Message message);
}
