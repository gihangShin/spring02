package com.hang.view.message;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hang.app.message.MessageVO;
import com.hang.app.message.impl.MessageDAO;

@Controller
public class MessageController {

	@RequestMapping(value = "/deleteMessage.do")
	public String deleteMessage(MessageVO vo, MessageDAO dao) {
		System.out.println("메세지 내용 삭제중 ...");
		StopWatch sw = new StopWatch();

		sw.start();
		dao.deleteMessage(vo);
		sw.stop();

		System.out.println("메세지 삭제 종료 시간 : " + sw.getTotalTimeMillis() + "ms");
		return "redirect:getMessageList.do";
	}

	@RequestMapping(value = "/getMessageList.do")
	public String getMessageList(MessageVO vo, MessageDAO dao, Model m) {
		System.out.println("메세지 목록 출력...");
		StopWatch sw = new StopWatch();

		sw.start();
		List<MessageVO> list = dao.getMessageList(vo);

		m.addAttribute("msgList", list);
		sw.stop();
		System.out.println("메세지 목록 출력 종료 시간 : " + sw.getTotalTimeMillis() + "ms");
		return "getMessageList.jsp";
	}

	@RequestMapping(value = "/insertMessage.do")
	public String insertMessage(MessageVO vo, MessageDAO dao) {
		System.out.println("메세지 삽입중 ...");
		StopWatch sw = new StopWatch();
		sw.start();

		dao.insertMessage(vo);

		sw.stop();
		System.out.println("메세지 삽입 종료 시간 : " + sw.getTotalTimeMillis() + "ms");
		return "redirect:getMessageList.do";
	}

	@RequestMapping(value = "/updateMessage.do")
	public String updateMessage(MessageVO vo, MessageDAO dao) {
		System.out.println("메세지 수정중 ...");
		StopWatch sw = new StopWatch();
		sw.start();

		dao.updateMessage(vo);

		sw.stop();
		System.out.println("메세지 수정 종료 시간 : " + sw.getTotalTimeMillis() + "ms");
		return "redirect:getMessageList.do";
	}
	//test입니다.

	@RequestMapping(value = "/getMessage.do")
	public String getMessage(MessageVO vo, MessageDAO dao, Model m) {
		System.out.println("메세지 수정중 ...");
		StopWatch sw = new StopWatch();
		sw.start();
		System.out.println("Controller MessageVO : " + vo);

		m.addAttribute("v", dao.getMessage(vo));

		sw.stop();
		System.out.println("메세지 수정 종료 시간 : " + sw.getTotalTimeMillis() + "ms");
		return "getMessage.jsp";
	}
}
