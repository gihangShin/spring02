package com.hang.view.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StopWatch;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hang.app.message.MessageVO;
import com.hang.app.message.impl.MessageDAO;

public class GetMessageListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("메세지 목록 출력...");
		StopWatch sw = new StopWatch();
		sw.start();
		MessageVO vo = new MessageVO();
		MessageDAO dao = new MessageDAO();
		List<MessageVO> list = dao.getMessageList(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getMessageList.jsp");
		mav.addObject("msgList", list);
		sw.stop();
		System.out.println("메세지 목록 출력 종료 시간 : "+sw.getTotalTimeMillis()+"ms");
		return mav;
	}

}
