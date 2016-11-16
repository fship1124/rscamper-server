package kr.co.rscamper.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.ChatRoomVO;
import kr.co.rscamper.domain.ChatUserVO;
import kr.co.rscamper.domain.CodeVO;
import kr.co.rscamper.service.ChatService;

@Controller
@RequestMapping("/chat/*")
public class ChatController {
	
	@Inject
	private ChatService service;
	
	private static final Logger logger = LoggerFactory.getLogger(TogetherController.class);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String chat() {
		logger.info("/chat > home");

		return "redirect:http://localhost:80/rscamper-web/views/chat/list.jsp";
	};
	
	
	@RequestMapping(value = "/room_list", method = RequestMethod.GET)
	public @ResponseBody List<ChatRoomVO> ajaxRoomList() throws Exception {
		logger.info("/chat > room list");

		List<ChatRoomVO> list = new ArrayList<>();
		list = service.list();
		System.out.println(list);
		
		CodeVO cVo = new CodeVO();
		for (ChatRoomVO vo : list) {
			cVo.setGroupCodeNo("areacode");
			cVo.setCodeNo(vo.getAreacode());
			String areaName = service.selectAreaNameBycode(cVo);
			vo.setAreaName(areaName);
			
			List<ChatUserVO> userList = new ArrayList<>();
			
			userList = service.selectRoomUserList(vo.getChatRoomInfoNo());
			vo.setRoomUserCnt(userList.size());
		}
		
		return list;
	};
	
	
	@RequestMapping(value = "/insert_user", method = RequestMethod.POST)
	public @ResponseBody void ajaxInsertUser(ChatUserVO uVo) throws Exception {
		logger.info("/chat > insert_user");
		
		System.out.println(uVo.getChatRoomInfoNo());
		System.out.println(uVo.getUserUid());
		
		// 채팅방 유저 입력
//		service.insertChatRoomUser(uVo);
	};
	
	
	@RequestMapping(value = "/list_user", method = RequestMethod.GET)
	public @ResponseBody List<ChatUserVO> listUser(@RequestParam("roomNo") int roomNo) throws Exception {
		logger.info("/chat > insert_user");
		
		System.out.println(roomNo);
		
		List<ChatUserVO> userList = new ArrayList<>();
		
		userList = service.selectRoomUserList(roomNo);
		
		System.out.println(userList.size());
		return userList;
	};
	
	
	
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detailChat(HttpServletRequest req,  HttpServletResponse res, @RequestParam("room") int roomNo, @RequestParam("location") String location,
			@RequestParam("title") String title) throws Exception {
		
		logger.info("/chat > detail");
		
		System.out.println(roomNo);
		System.out.println(location);
		System.out.println(title);
		
		CodeVO cVo = new CodeVO();
		cVo.setGroupCodeNo("areacode");
		cVo.setCodeNo(roomNo);
		String areaName = service.selectAreaNameBycode(cVo);
		
		
		location = URLEncoder.encode(location, "UTF-8");
		title = URLEncoder.encode(title, "UTF-8");
		areaName = URLEncoder.encode(areaName, "UTF-8");
		
		return "redirect:http://localhost:80/rscamper-web/views/chat/detail.jsp?room=" + areaName + "&location=" + location + "&title=" + title;
	};
	
	
	
	
	
	
	
	
}






