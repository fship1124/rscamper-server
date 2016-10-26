package kr.co.rscamper.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.MainVO;
import kr.co.rscamper.service.MainService;

@Controller
@RequestMapping("/main/*")
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Inject
	private MainService service;
	
	
	@RequestMapping(value = "/{uid} /{content}", method = RequestMethod.PUT)
	public @ResponseBody MainVO insert(@PathVariable("uid") String uid, @PathVariable("content") String content, HttpServletResponse res) throws Exception {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		logger.info("/main");
		logger.info(service.getTime());
		
		logger.info("uid : " + uid);
		logger.info("content : " + content);
		
		MainVO vo = new MainVO();
		service.insertMainComment(vo);
		vo.setUserUid(uid);
		vo.setMainContent(content);

		return vo;
	}
}
