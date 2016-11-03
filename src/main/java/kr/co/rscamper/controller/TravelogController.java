package kr.co.rscamper.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.rscamper.domain.PageMaker;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.TravelogVO;
import kr.co.rscamper.service.TravelogService;
import kr.co.rscamper.service.UserService;

@Controller
@RequestMapping("/travelog/*")
public class TravelogController {
	
	private static final Logger logger = LoggerFactory.getLogger(TravelogController.class);
	
	@Autowired
	private TravelogService travelogservice;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String travelog() {
		logger.info("/travelog > home");
		
		return "redirect:http://localhost:80/rscamper-web/views/travelog/list.jsp";
	}
	
	// 게시물 목록 확인
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public @ResponseBody  Map<String, Object> read(PageVO vo) throws Exception{
		logger.info("/travelog > List");
		
		List<TravelogVO> list = new ArrayList<>();
		list = travelogservice.listTravelog(vo);
		
		int totalCount = travelogservice.totalCount();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPage(vo);
		pageMaker.setTotalCount(totalCount);
		Map<String, Object> map = new HashMap<>();
		map.put("page", list);
		map.put("pageMaker", pageMaker);
		return map;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGET(TravelogVO travelog, Model model) throws Exception {
		logger.info("register get...............");
		return "redirect:/travelog/";
	}
	
	// 게시물 실제 등록
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPost(TravelogVO travelog, RedirectAttributes rttr) throws Exception {
		travelogservice.regist(travelog);
		rttr.addAttribute("msg", "SUCCESS");
		return "redirect:/travelog/home";
	}
	
	
	
	
	
}
