package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.CommentVO;
import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.TravelogVO;

public interface TravelogDAO {

	public String getTime() throws Exception;
	
	public List<TravelogVO> listTravelog(PageVO page) throws Exception;
	
	public int totalCount() throws Exception;
	
	public void insertTravelog(TravelogVO travelog) throws Exception;

	public TravelogVO selectByNo(int bNo) throws Exception;
	
	// comment ============================= 
	
	public List<CommentVO> listComment(Integer boardNo) throws Exception;
	
	public void insertComment(CommentVO comment) throws Exception;
	
	public void updateComment(CommentVO comment) throws Exception;
	
	public void delteteComment(Integer commentNo) throws Exception;
	
}
