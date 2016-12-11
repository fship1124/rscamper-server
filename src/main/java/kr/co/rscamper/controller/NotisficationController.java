package kr.co.rscamper.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.rscamper.domain.CodeVO;
import kr.co.rscamper.domain.NotisficationVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.service.ChatService;
import kr.co.rscamper.service.NotisficationService;
import kr.co.rscamper.service.UserService;

@RestController
@RequestMapping("/notisfication/*")
public class NotisficationController {
	
	@Inject
	private NotisficationService service;
	@Inject 
	private UserService userService;
	@Inject
	private ChatService chatService;
	
	private static final Logger logger = LoggerFactory.getLogger(NotisficationController.class);
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public @ResponseBody List<NotisficationVO> list(@RequestParam("userUid") String userUid) throws Exception {
		logger.info("in notisfication > list");
		
		List<NotisficationVO> list = new ArrayList<>();
		list = service.list(userUid);
		
		for (NotisficationVO vo : list) {
			UserVO uVo = userService.selectUserByUid(vo.getTargetUserUid());
			vo.setDisplayName(uVo.getDisplayName());
			vo.setPhotoUrl(uVo.getPhotoUrl());
			
			CodeVO cVo = new CodeVO();
			
			switch(vo.getType()) {
			case "1": case "2": case "3":
				cVo.setGroupCodeNo("notisfication_code");
				break;
			case "4": case "5": case "6": 
				System.out.println("~~~~~");
				break;
			}
			
			cVo.setCodeNo(Integer.parseInt(vo.getType()));
			String codeName = chatService.selectAreaNameBycode(cVo);
			vo.setCodeName(codeName);
		}
		
		return list;
	}
	
	
	@RequestMapping(value="/delete/{no}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteByNo(@PathVariable("no") int no) throws Exception {
		logger.info("in notisfication > delete");
//		System.out.print("notificationNO : ");
//		System.out.println(no);
		service.deleteByNo(no);
	};
}
