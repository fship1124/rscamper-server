package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.CommentVO;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.TravelogVO;
import kr.co.rscamper.persistence.TravelogDAO;

@Service
public class TravelogServiceImple implements TravelogService {
	
	@Inject
	private TravelogDAO dao;

	@Override
	public String getTime() throws Exception {
		return dao.getTime();
	}

	@Override
	public List<TravelogVO> listTravelog(PageVO page) throws Exception {
		return dao.listTravelog(page);
	}

	@Override
	public int totalCount() throws Exception {
		return dao.totalCount();
	}

	
	@Override
	public void regist(TravelogVO travelog) throws Exception {
		dao.insertTravelog(travelog);
	}

	@Override
	public TravelogVO selectByNo(int boardNo) throws Exception {
		return dao.selectByNo(boardNo);
	}

	@Override
	public void deleteBoardByBoardNo(int boardNo) throws Exception {
		dao.deleteBoardByBoardNo(boardNo);
	}
	
	@Override
	public void addCommnet(CommentVO cVo) throws Exception {
		dao.insertComment(cVo);
	}

	@Override
	public List<CommentVO> listComment(Integer boardNo, PageVO page) throws Exception {
		return dao.listComment(boardNo, page);
	}

	@Override
	public void modifyComment(CommentVO comment) throws Exception {
		dao.updateComment(comment);
	}

	@Override
	public void removeComment(Integer commentNo) throws Exception {
		dao.delteteComment(commentNo);
	}

	@Override
	  public int count(Integer boardNo) throws Exception {
	    return dao.count(boardNo);
	  }

	@Override
	public int totalCountComment(Integer boardNo) throws Exception {
		return dao.totalCountComment(boardNo);
	}
		

	
}
