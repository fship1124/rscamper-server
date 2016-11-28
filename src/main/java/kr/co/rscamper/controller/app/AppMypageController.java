package kr.co.rscamper.controller.app;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.rscamper.service.AppMypageService;

@Controller
@RequestMapping("/app/mypage/*")
public class AppMypageController {

	@Inject
	private AppMypageService service;
	private static final Logger logger = LoggerFactory.getLogger(AppMypageController.class);
	
	
	
}
