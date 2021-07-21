package com.hang.app;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hang.app.message.MessageService;
import com.hang.app.message.MessageVO;

public class Client {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		MessageService ms =(MessageService)factory.getBean("MessageService");
		MessageVO vo = new MessageVO();
		
		vo.setContent("오늘은 금요일");
		vo.setWriter("ADMIN");
		ms.insertMessage(vo);
		
		System.out.println("메세지 전체 출력");
		List<MessageVO> list = ms.getMessageList(vo);
		for(MessageVO v : list) {
			System.out.println(v);
		}
		factory.close();
	}
}
