package kr.co.rscamper.service;

import java.util.List;
import java.util.Map;

import kr.co.rscamper.domain.CommentVO;
import kr.co.rscamper.domain.CommunityVO;

public interface CommunityService {

	/** 커뮤니티 게시글(+유저정보)(페이징) 가져오기 */
	public Map<String, Object> selectCommunityList(int page);

	/** 커뮤니티 게시글 하나 정보 가져오기 */
	public CommunityVO selectCommunity(int boardNo);

	/** 커뮤니티 게시판 카테고리 리스트 가져오기 */
	public List<CommunityVO> selectCategoryList();

	/** 게시글 입력 
	 * @param community */
	public void insertBoard(CommunityVO community);

	/** 게시물 삭제 */
	public void deleteBoardByBoardNo(int boardNo);

	/** 댓글(+유저정보)(페이징) 가져오기 */
	public Map<String, Object> selectCommentList(int page, int boardNo);

	/** 댓글 입력 */
	public void insertComment(CommentVO comment);

	/** 댓글 삭제 */
	public void deleteCommentByCommentNo(int commentNo);

	/** 댓글 수정 */
	public void updateCommentByCommentNo(CommentVO comment);
	
}
