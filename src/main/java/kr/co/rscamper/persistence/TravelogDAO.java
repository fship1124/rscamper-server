package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.TravelogVO;

public interface TravelogDAO {

	public String getTime() throws Exception;
	
	public List<TravelogVO> listAllTravelog() throws Exception;
	
	public void insertTravelog(TravelogVO travelog) throws Exception;
	
}
