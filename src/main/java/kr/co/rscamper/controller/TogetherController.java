package kr.co.rscamper.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.TogetherVO;

@Controller
@RequestMapping("/together/*")
public class TogetherController {
	private static final Logger logger = LoggerFactory.getLogger(TogetherController.class);
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String together() {
		logger.info("/together > home");
		
		return "redirect:http://192.168.0.173:80/rscamper-web/views/together/list.jsp";
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody List<TogetherVO> read(HttpServletResponse res) throws Exception {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		logger.info("/together > List");
		
		
		return null;
	}
	
}
