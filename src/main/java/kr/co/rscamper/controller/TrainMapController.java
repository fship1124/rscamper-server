package kr.co.rscamper.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/trainMap/*")
public class TrainMapController {
	
	private static final Logger logger = LoggerFactory.getLogger(TrainMapController.class);
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String trainMap() {
		logger.info("/trainMap > home");
		
		return "redirect:http://localhost:80/rscamper-web/views/train/trainMap.jsp";
	}
}
