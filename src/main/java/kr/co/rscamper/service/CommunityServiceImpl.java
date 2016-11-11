package kr.co.rscamper.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.CommentVO;
import kr.co.rscamper.domain.CommunityVO;
import kr.co.rscamper.persistence.CommunityDAO;
import kr.co.rscamper.persistence.UserDAO;

@Service
public class CommunityServiceImpl implements CommunityService {

	@Inject
	public CommunityDAO dao;
	
	@Inject
	public UserDAO userDao;

	@Override
	public Map<String, Object> selectCommunityList(int page) {
		// 페이징 카운트
		int COUNT = 10;
		page = (page - 1) * COUNT;

		int totalPages = (int) Math.ceil((double) dao.selectCommunityTotalPages() / (double) COUNT);
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("count", COUNT);
		pageMap.put("page", page);
		List<CommunityVO> board = dao.selectCommunityList(pageMap);

		Map<String, Object> boardMap = new HashMap<>();
		boardMap.put("board", board);
		boardMap.put("totalPages", totalPages);
		return boardMap;
	}

	@Override
	public List<CommunityVO> selectCategoryList() {
		return dao.selectCategoryList();
	}

	@Override
	public void insertBoard(CommunityVO community) {
		dao.insertBoard(community);
	}

	@Override
	public CommunityVO selectCommunity(int boardNo) {
		return dao.selectCommunity(boardNo);
	}

	@Override
	public void deleteBoardByBoardNo(int boardNo) {
		dao.deleteBoardByBoardNo(boardNo);
	}

	@Override
	public Map<String, Object> selectCommentList(int page, int boardNo) {
		// 페이징 카운트
		int COUNT = 4;
		page = (page - 1) * COUNT;
		
		int totalPages = (int) Math.ceil((double) dao.selectCommentTotalPages(boardNo) / (double) COUNT);
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("count", COUNT);
		pageMap.put("page", page);
		pageMap.put("boardNo", boardNo);
		List<CommentVO> comment = dao.selectCommentList(pageMap);

		Map<String, Object> commentMap = new HashMap<>();
		commentMap.put("comment", comment);
		commentMap.put("totalPages", totalPages);
		return commentMap;
	}

	@Override
	public void insertComment(CommentVO comment) {
		dao.insertComment(comment);
	}

	@Override
	public void deleteCommentByCommentNo(int commentNo) {
		dao.deleteCommentByCommentNo(commentNo);
	}

	@Override
	public void updateCommentByCommentNo(CommentVO comment) {
		dao.updateCommentByCommentNo(comment);
	}

}
