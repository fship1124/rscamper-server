package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.PageVO;
import kr.co.rscamper.domain.TravelogVO;

public interface TravelogDAO {

	public String getTime() throws Exception;
	
	public List<TravelogVO> listTravelog(PageVO vo) throws Exception;
	
	public int totalCount() throws Exception;
	
	public void insertTravelog(TravelogVO travelog) throws Exception;
	
}
