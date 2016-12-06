/**-----------------------------------------------------------------------
 * rscamper Project
 * ------------------------------------------------------------------------
 * @Class MainController.java
 * @Description 메인 페이지 실시간 댓글 요청에 대한 처리를 위한 Handler 클래스  
 * @author 김호동
 * @since 2016. 10. 15.
 */

package kr.co.rscamper.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.BenefitVO;
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
//	@Inject
//	private BenefitService service;

	
	/**
	 * @Description 메인 페이지 실시간 댓글 리스트 정보 요청에 대한 처리
	 * @param none
	 * @return List DB에 저장된 댓글 목록
	 */
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
		return list;
	}
	
	
	/**
	 * @Description 메인 페이지 실시간 댓글 리스트 정보 요청에 대한 처리
	 * @param none
	 * @return List DB에 저장된 댓글 목록
	 */
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
		return list;
	}
	
	@RequestMapping(value="benefitList", method = RequestMethod.GET)
	public @ResponseBody List<BenefitVO> list()throws Exception {
		logger.info("/benefitList > list");
		
<<<<<<< HEAD
		List<BenefitVO> list = new ArrayList<>();
		list = mainService.list();
		return list;
=======
		BenefitVO bvo = new BenefitVO();
		return mainService.selectList(benefitno);
>>>>>>> master
	}
	
	
	
}
