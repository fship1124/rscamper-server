package kr.co.rscamper.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/post/*")
public class PostController {
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String post() {
		logger.info("/post > home");
		
		return "redirect:http://localhost:80/rscamper-web/views/post/list.jsp";
	}
	
	
	
	
	
}
