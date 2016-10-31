package kr.co.rscamper.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/tour/*")
public class TourController {
	private static final Logger logger = LoggerFactory.getLogger(TourController.class);
<<<<<<< HEAD
=======
	
>>>>>>> dh
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String together() {
		logger.info("/tour > home");
		
		return "redirect:http://localhost:80/rscamper-web/views/tour/list.jsp";
	}
}
