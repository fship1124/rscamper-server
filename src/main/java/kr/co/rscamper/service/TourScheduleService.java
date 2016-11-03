package kr.co.rscamper.service;

import java.util.List;

import kr.co.rscamper.domain.RecordCoverVO;
import kr.co.rscamper.domain.TourScheduleVO;

public interface TourScheduleService {
	public List<TourScheduleVO> getSchedule(String uid) throws Exception;
	
	public void insertSchedule(TourScheduleVO tv) throws Exception;
	
	public void delSchedule(int no) throws Exception;
	
	public void changeCover(RecordCoverVO rc) throws Exception;
	
	public void insertCover(RecordCoverVO rc) throws Exception;
	
	public RecordCoverVO getCover(int no) throws Exception;
	
	public TourScheduleVO getDetailTourSchedule(int no) throws Exception;
	
}
