package kr.co.rscamper.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.CommunityVO;
import kr.co.rscamper.persistence.CommunityDAO;

@Service
public class CommunityServiceImpl implements CommunityService {

	@Inject
	public CommunityDAO dao;

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

}
