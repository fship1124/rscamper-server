package kr.co.rscamper.persistence;


import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rscamper.domain.CommunityVO;

@Repository
public class CommunityDAOImpl implements CommunityDAO {
	
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final String namespace = "kr.co.rscamper.CommunityMapper";

	@Override
	public List<CommunityVO> selectCommunityList(Map pageMap) {
		return sqlSessionTemplate.selectList(namespace + ".selectCommunityList", pageMap);
	}

	@Override
	public int selectCommunityTotalPages() {
		return sqlSessionTemplate.selectOne(namespace + ".selectCommunityTotalPages");
	}

	@Override
	public List<CommunityVO> selectCategoryList() {
		return sqlSessionTemplate.selectList(namespace + ".selectCategoryList");
	}

	@Override
	public void insertBoard(CommunityVO community) {
		sqlSessionTemplate.insert(namespace + ".insertBoard", community);
	}

	@Override
	public CommunityVO selectCommunity(int boardNo) {
		return sqlSessionTemplate.selectOne(namespace + ".selectCommunity", boardNo);
	}

	@Override
	public void deleteBoardByBoardNo(int boardNo) {
		sqlSessionTemplate.delete(namespace + ".deleteBoardByBoardNo", boardNo);
	}
	
	
	
}
