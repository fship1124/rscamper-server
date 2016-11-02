package kr.co.rscamper.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.PostVO;
import kr.co.rscamper.service.PostService;
import kr.co.rscamper.service.UserService;

@Controller
@RequestMapping("/post/*")
public class PostController {
	
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@Autowired
	private PostService postservice;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String post() {
		logger.info("/post > home");
		
		return "redirect:http://localhost:80/rscamper-web/views/post/list.jsp";
	}
	
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public @ResponseBody List<PostVO> list() throws Exception{

		List<PostVO> list = new ArrayList<>();
		list = postservice.listAll();
		System.out.println(list.size());
		return list;
	}
	
	
	
}
