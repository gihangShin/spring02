package com.hang.app.message;

import java.util.List;

public interface MessageService {
	public List<MessageVO> getMessageList(MessageVO vo);

	public MessageVO getMessage(MessageVO vo);

	public void insertMessage(MessageVO vo);

	public void updateMessage(MessageVO vo);

	public void deleteMessage(MessageVO vo);
}
