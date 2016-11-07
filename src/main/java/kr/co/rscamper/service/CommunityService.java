package kr.co.rscamper.service;

import java.util.List;
import java.util.Map;

import kr.co.rscamper.domain.CommunityVO;

public interface CommunityService {

	/** 커뮤니티 게시글(+유저정보)(페이징) 가져오기 */
	public Map<String, Object> selectCommunityList(int page);

	/** 커뮤니티 게시판 카테고리 리스트 가져오기 */
	public List<CommunityVO> selectCategoryList();

	/** 게시글 입력 
	 * @param community */
	public void insertBoard(CommunityVO community);

}
