package kr.co.rscamper.controller.app;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.CommunityVO;
import kr.co.rscamper.service.CommunityService;

@Controller
@RequestMapping("/app/community/*")
public class AppCommunityController {
	private static final Logger logger = LoggerFactory.getLogger(AppCommunityController.class);

	@Inject
	private CommunityService communityService;
	
	@RequestMapping(value = "/select/board", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> selectCommunityList(int page) throws Exception {
		return communityService.selectCommunityList(page);
	}
	
	@RequestMapping(value = "/select/category", method = RequestMethod.GET)
	public @ResponseBody List<CommunityVO> selectCategoryList() throws Exception {
		return communityService.selectCategoryList();
	}
	
	@RequestMapping(value = "/insert/board", method = RequestMethod.POST)
	public @ResponseBody void insertBoard(CommunityVO community) throws Exception {
		communityService.insertBoard(community);
	}
	
}