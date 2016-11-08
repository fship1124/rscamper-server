package kr.co.rscamper.persistence;

import java.util.List;
import java.util.Map;

import kr.co.rscamper.domain.CommunityVO;

public interface CommunityDAO {

	// 페이징 처리된 게시판 리스트 조회
	public List<CommunityVO> selectCommunityList(Map<?, ?> pageMap);

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
	
}
