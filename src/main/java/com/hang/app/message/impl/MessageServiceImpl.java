package com.hang.app.message.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hang.app.message.MessageService;
import com.hang.app.message.MessageVO;

@Service("MessageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDAO messageDAO;

	@Override
	public List<MessageVO> getMessageList(MessageVO vo) {
		return messageDAO.getMessageList(vo);
	}

	@Override
	public MessageVO getMessage(MessageVO vo) {
		// TODO Auto-generated method stub
		return messageDAO.getMessage(vo);
	}

	@Override
	public void insertMessage(MessageVO vo) {
		messageDAO.insertMessage(vo);
	}

	@Override
	public void updateMessage(MessageVO vo) {
		messageDAO.updateMessage(vo);
	}

	@Override
	public void deleteMessage(MessageVO vo) {
		messageDAO.deleteMessage(vo);
	}

}
