package kr.co.rscamper.persistence;

import java.util.List;
import java.util.Map;

import kr.co.rscamper.domain.CommentVO;
import kr.co.rscamper.domain.CommunityVO;

public interface CommunityDAO {

	// 페이징 처리된 게시판 리스트 조회
	public List<CommunityVO> selectCommunityList(Map<String, Integer> pageMap);

	// 전체 게시물 카운트 조회
	public int selectCommunityTotalPages();

	// 게시판 카테고리 조회
	public List<CommunityVO> selectCategoryList();

	// 게시글 입력
	public void insertBoard(CommunityVO community);

	// 게시물 하나 조회
	public CommunityVO selectCommunity(int boardNo);

	// 게시물 하나 삭제
	public void deleteBoardByBoardNo(int boardNo);

	// 전체 댓글 카운트 조회
	public int selectCommentTotalPages(int boardNo);

	// 페이징 처리된 댓글 리스트 조회
	public List<CommentVO> selectCommentList(Map<String, Integer> pageMap);

	// 댓글 입력
	public void insertComment(CommentVO comment);

	// 댓글 삭제
	public void deleteCommentByCommentNo(int commentNo);

	// 댓글 수정
	public void updateCommentByCommentNo(CommentVO comment);
	
}
