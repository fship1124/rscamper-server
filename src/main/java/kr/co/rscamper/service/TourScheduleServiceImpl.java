package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.RecordCoverVO;
import kr.co.rscamper.domain.TourScheduleVO;
import kr.co.rscamper.persistence.TourScheduleDAO;

@Service
public class TourScheduleServiceImpl implements TourScheduleService {
	
	@Inject
	private TourScheduleDAO dao;

	@Override
	public List<TourScheduleVO> getSchedule(String uid) throws Exception {
		return dao.getSchedule(uid);
	}

	@Override
	public void insertSchedule(TourScheduleVO tv) throws Exception {
		dao.insertSchedule(tv);
	}

	@Override
	public void delSchedule(int no) throws Exception {
		dao.delSchedule(no);
	}

	@Override
	public void changeCover(RecordCoverVO rc) throws Exception {
		dao.changeCover(rc);
		
	}

	@Override
	public void insertCover(RecordCoverVO rc) throws Exception {
		dao.insertCover(rc);
	}

	@Override
	public RecordCoverVO getCover(int no) throws Exception {
		
		return dao.getCover(no);
	}

	@Override
	public TourScheduleVO getDetailTourSchedule(int no) throws Exception {
		return dao.getDetailTourSchedule(no);
	}

}
