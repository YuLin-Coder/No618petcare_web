package com.pet.service.impl;

import java.util.List;

import com.pet.dao.MessagesDao;
import com.pet.dao.impl.MessagesDaoImpl;
import com.pet.entity.Messages;
import com.pet.service.MessagesService;

public class MessagesServiceImpl implements MessagesService{
	private MessagesDao dao=new MessagesDaoImpl();

	public int addMessages(Messages record) {
		// TODO Auto-generated method stub
		return dao.save(record);
	}

	public Messages findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.query(id);
	}

	public int updateMessages(Messages record) {
		// TODO Auto-generated method stub
		return dao.update(record);
	}

	public List<Messages> getPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getPage(pageNum, pageSize);
	}

	public List<Messages> findAllMessages() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public List<Messages> findMessagesByMap(String name) {
		// TODO Auto-generated method stub
		return dao.findByMap(name);
	}

	public int queryMessagesCount() {
		// TODO Auto-generated method stub
		return dao.queryCount();
	}

	public int deleteMessages(Integer id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public List<Messages> findMyMessages(int uid) {
		// TODO Auto-generated method stub
		return dao.findMyMessages(uid);
	}

	
}
