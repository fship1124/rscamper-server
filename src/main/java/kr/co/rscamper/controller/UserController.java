package kr.co.rscamper.controller;

import java.util.Date;
import java.util.HashMap;

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
@RequestMapping("/user/*")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService service;
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String user() {
		logger.info("eeeeeeeeeeeeee");
		return "redirect:http://192.168.0.173:80/rscamper-web/views/user/user.jsp";
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public @ResponseBody void insert(UserVO user) throws Exception{
		System.out.println(user.toString());
		service.insertUser(user);
	}
	
/*	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String updateGET(int userUid, Model model)throws Exception{
		
		// service.회원정보번호?
		return "redirect:http://localhost:80/rscamper-web/views/user.jsp";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String updatePOST(UserVO user)throws Exception {
		
		service.updateUser(user);
		
		return "redirect:http://localhost:80/rscamper-web/views/main.jsp";
	}
	*/
//	@RequestMapping(value="/update", method = RequestMethod.POST)
//	public String update(String userUid, String displayName, String photoUrl, String email, String bgphotoUrl, 
//			int locationNo, String phoneNumber, String websiteUrl, String introduce, Date birthday, Date regDate)throws Exception {
//		UserVO user = new UserVO();
//		user.setUserUid(userUid);
//		user.setDisplayName(displayName);
//		user.setPhotoUrl(bgphotoUrl);
//		user.setEmail(email);
//		user.setLocationNo(locationNo);
//		user.setPhoneNumber(phoneNumber);
//		user.setWebsiteUrl(websiteUrl);
//		user.setIntroduce(introduce);
//		user.setBirthday(birthday);
//		user.setRegDate(regDate);
//		
//		HashMap<String, Object> result = new HashMap<>();
//		try {
//			service.updateUser(user);
//			result.put("login", "success");
//		} catch (Exception e) {
//			result.put("login", "fail");
//			e.printStackTrace();
//		}
//		
//		return "redirect:http://192.168.0.173:80/rscamper-web/views/main.jsp";
//	}
//	
	
}