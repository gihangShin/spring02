package com.hang.view.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StopWatch;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hang.app.message.MessageVO;
import com.hang.app.message.impl.MessageDAO;

public class DeleteMessageController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("메세지 내용 삭제중 ...");
		StopWatch sw = new StopWatch();
		sw.start();
		MessageDAO dao = new MessageDAO();
		MessageVO vo = new MessageVO();

		vo.setMid(Integer.parseInt(req.getParameter("mid")));

		dao.deleteMessage(vo);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("getMessageList.do");
		sw.stop();
		System.out.println("메세지 삭제 종료 시간 : " + sw.getTotalTimeMillis() + "ms");
		return mav;
	}

}
