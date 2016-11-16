package kr.co.rscamper.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.CommentVO;
import kr.co.rscamper.domain.CommunityVO;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.service.CommunityService;

@Controller
@RequestMapping("/community/*")
public class CommunityController {
	private static final Logger logger = LoggerFactory.getLogger(CommunityController.class);

	@Inject
	private CommunityService communityService;
	
	@RequestMapping(value = "/select/board", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> selectCommunityList(int page) throws Exception {
		return communityService.selectCommunityList(page, 10);
	}
	
	@RequestMapping(value = "/select/categoryBoard", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> selectCommunityList(int page, int categoryNo) throws Exception {
		System.out.println("page:"+ page + "categoryNo:"+ categoryNo );
		return communityService.selectCommunityListByCategoryNo(page, 10, categoryNo);
	}
	
	@RequestMapping(value = "/select/oneBoard", method = RequestMethod.GET)
	public @ResponseBody CommunityVO selectCommunity(int boardNo) throws Exception {
		return communityService.selectCommunity(boardNo);
	}
	
	@RequestMapping(value = "/select/category", method = RequestMethod.GET)
	public @ResponseBody List<CommunityVO> selectCategoryList() throws Exception {
		return communityService.selectCategoryList();
	}
	
	@RequestMapping(value = "/insert/board", method = RequestMethod.POST)
	public @ResponseBody void insertBoard(CommunityVO community) throws Exception {
		communityService.insertBoard(community);
	}
	
	@RequestMapping(value = "/update/oneBoard", method = RequestMethod.POST)
	public @ResponseBody void updateBoardByBoardNo(CommunityVO community) throws Exception {
		communityService.updateboardByBoardNo(community);
	}
	
	@RequestMapping(value = "/delete/oneBoard", method = RequestMethod.DELETE)
	public @ResponseBody void deleteBoardByBoardNo(int boardNo) throws Exception {
		communityService.deleteBoardByBoardNo(boardNo);
	}
	
	@RequestMapping(value = "/select/comment", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> selectCommentList(int page, int boardNo) throws Exception {
		return communityService.selectCommentList(page, boardNo, 10);
	}
	
	@RequestMapping(value = "/insert/comment", method = RequestMethod.POST)
	public @ResponseBody void insertComment(CommentVO comment) throws Exception {
		communityService.insertComment(comment);
	}
	
	@RequestMapping(value = "/update/oneComment", method = RequestMethod.POST)
	public @ResponseBody void updateCommentByCommentNo(CommentVO comment) throws Exception {
		System.out.println(comment.toString());
		communityService.updateCommentByCommentNo(comment);
	}
	
	@RequestMapping(value = "/delete/oneComment", method = RequestMethod.DELETE)
	public @ResponseBody void deleteCommentByCommentNo(int commentNo) throws Exception {
		communityService.deleteCommentByCommentNo(commentNo);
	}
	

	
}