package kr.co.rscamper.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.MainVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.service.MainService;
import kr.co.rscamper.service.UserService;

@Controller
@RequestMapping("/main/*")
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Inject
	private MainService mainService;
	@Inject
	private UserService userService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody List<MainVO> read(HttpServletResponse res) throws Exception {
		logger.info("/main > read");
		
		List<MainVO> list = new ArrayList<>();
		list = mainService.selectMainComment();
		
		for (MainVO val : list) {
			UserVO uVo = userService.selectMainByUidComment(val.getUserUid());
			val.setDisplayName(uVo.getDisplayName());
			val.setProviderPhotoUrl(uVo.getPhotoUrl());
		}
		System.out.println(list.size());
		return list;
	}
	
	
	@RequestMapping(value = "/{uid}/{content}", method = RequestMethod.PUT)
	public @ResponseBody List<MainVO> insert(@PathVariable("uid") String uid, @PathVariable("content") String content, HttpServletResponse res) throws Exception {
		logger.info("/main > insert");
		
		MainVO mVo = new MainVO();
		mVo.setUserUid(uid);
		mVo.setMainContent(content);
		
		mainService.insertMainComment(mVo);
		
		List<MainVO> list = new ArrayList<>();
		list = mainService.selectMainComment();
		
		for (MainVO val : list) {
			UserVO uVo = userService.selectMainByUidComment(val.getUserUid());
			val.setDisplayName(uVo.getDisplayName());
			val.setProviderPhotoUrl(uVo.getPhotoUrl());
		}
		System.out.println(list.size());
		return list;
	}
}
