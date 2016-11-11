package kr.co.rscamper.service;

import java.util.List;
import java.util.Map;

import kr.co.rscamper.domain.CommentVO;
import kr.co.rscamper.domain.CommunityVO;

public interface CommunityService {

	/** 커뮤니티 게시글 리스트(전체) (+유저정보)(페이징) 가져오기 
	 * @param page(페이지번호)
	 * @param count(페이지당 가져올 리스트 개수)
	 * @return Map(boardList(게시글 리스트),  totalPages(총 페이지수))
	 */ 
	public Map<String, Object> selectCommunityList(int page, int count);
	
	/** 커뮤니티 게시글 리스트(게시판별로) (+유저정보)(페이징) 가져오기 
	 * @param page(페이지번호)
	 * @param count(페이지당 가져올 리스트 개수)
	 * @param categoryNo(게시판종류)
	 * @return Map(boardList(게시글 리스트),  totalPages(총 페이지수))
	 */ 
	public Map<String, Object> selectCommunityListByCategoryNo(int page, int count, int categoryNo);

	/** 커뮤니티 게시글 하나 정보 가져오기 */
	public CommunityVO selectCommunity(int boardNo);
	
	/** 커뮤니티 게시판 카테고리 리스트 가져오기 */
	public List<CommunityVO> selectCategoryList();

	/** 게시글 입력 */
	public void insertBoard(CommunityVO community);
	
	/** 게시글 수정 */
	public void updateboardByBoardNo(CommunityVO community);

	/** 게시물 삭제 */
	public void deleteBoardByBoardNo(int boardNo);
	
	/** 댓글 리스트 (+유저정보)(페이징) 조회
	 * @param page(페이지번호)
	 * @param boardNo
	 * @param count(페이지당 가져올 리스트 개수)
	 * @return Map(CommentList(댓글 리스트), totalPages(총 페이지수))
	 */
	public Map<String, Object> selectCommentList(int page, int boardNo, int count);

	/** 댓글 입력 */
	public void insertComment(CommentVO comment);

	/** 댓글 삭제 */
	public void deleteCommentByCommentNo(int commentNo);

	/** 댓글 수정 */
	public void updateCommentByCommentNo(CommentVO comment);
	
}
