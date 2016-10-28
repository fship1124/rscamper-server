package kr.co.rscamper.controller.app;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.service.UserService;

@Controller
@RequestMapping("/app/user/*")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService userService;
	
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public @ResponseBody void insert(UserVO user) throws Exception{
		userService.insertUser(user);
	}
	
}