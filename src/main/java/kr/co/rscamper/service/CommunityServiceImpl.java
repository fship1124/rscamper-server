package kr.co.rscamper.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.BoardBookMarkVO;
import kr.co.rscamper.domain.BoardLikeVO;
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
	public Map<String, Object> selectCommunityList(int page, int count) {
		page = (page - 1) * count;
		System.out.println(dao.selectCommunityTotalPages());

		int totalPages = (int) Math.ceil((double) dao.selectCommunityTotalPages() / (double) count);
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("count", count);
		pageMap.put("page", page);
		List<CommunityVO> boardList = dao.selectCommunityList(pageMap);

		Map<String, Object> boardMap = new HashMap<>();
		boardMap.put("boardList", boardList);
		boardMap.put("totalPages", totalPages);
		return boardMap;
	}
	
	@Override
	public Map<String, Object> selectCommunityListByCategoryNo(int page, int count, int categoryNo) {
		page = (page - 1) * count;
		System.out.println(dao.selectCommunityTotalPagesByCategoryNo(categoryNo));
		
		int totalPages = (int) Math.ceil((double) dao.selectCommunityTotalPagesByCategoryNo(categoryNo) / (double) count);
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("page", page);
		pageMap.put("count", count);
		pageMap.put("categoryNo", categoryNo);
		System.out.println("page:"+page+"count"+count+"categoryNo"+ categoryNo);
		List<CommunityVO> boardList = dao.selectCommunityListByCategoryNo(pageMap);
		System.out.println("totalPages:" + totalPages);

		Map<String, Object> boardMap = new HashMap<>();
		boardMap.put("boardList", boardList);
		boardMap.put("totalPages", totalPages);
		boardMap.put("count", count);
		boardMap.put("page", page);
		
		System.out.println(boardMap);
		System.out.println(boardList.get(0).toString());
		
		return boardMap;
	}

	@Override
	public List<CommunityVO> selectCategoryList() {
		return dao.selectCategoryList();
	}

	@Override
	public CommunityVO selectCommunity(int boardNo) {
		return dao.selectCommunity(boardNo);
	}

	@Override
	public void insertBoard(CommunityVO community) {
		dao.insertBoard(community);
	}
	
	@Override
	public void updateboardByBoardNo(CommunityVO community) {
		dao.updateboardByBoardNo(community);
	}

	@Override
	public void deleteBoardByBoardNo(int boardNo) {
		dao.deleteBoardByBoardNo(boardNo);
	}

	
	@Override
	public Map<String, Object> selectCommentList(int page, int boardNo, int count) {
		page = (page - 1) * count;
		
		int totalPages = (int) Math.ceil((double) dao.selectCommentTotalPages(boardNo) / (double) count);
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("count", count);
		pageMap.put("page", page);
		pageMap.put("boardNo", boardNo);
		List<CommentVO> commentList = dao.selectCommentList(pageMap);

		Map<String, Object> commentMap = new HashMap<>();
		commentMap.put("commentList", commentList);
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

	@Override
	public boolean likeProcess(BoardLikeVO boardLike) {
		if (dao.selectBoardLike(boardLike) == 0) {
			dao.insertBoardLike(boardLike);
			return false;
		} else {
			dao.deleteBoardLike(boardLike);
			return true;
		}
	}

	@Override
	public boolean bookMarkProcess(BoardBookMarkVO boardBookMark) {
		if (dao.selectBoardBookMark(boardBookMark) == 0) {
			dao.insertBoardBookMark(boardBookMark);
			return false;
		} else {
			dao.deleteBoardBookMark(boardBookMark);
			return true;
		}
	}

	@Override
	public boolean selectBookMarkStatus(BoardBookMarkVO boardBookMark) {
		if (dao.selectBoardBookMark(boardBookMark) == 0) {
			return false;
		} else {
			return true;
		}
	}
}
