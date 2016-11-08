package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.TrainVO;
import kr.co.rscamper.persistence.TrainDAO;

@Service
public class TrainServiceImpl implements TrainService{
	
	@Inject
	private TrainDAO dao;
	
	
	@Override
	public List<TrainVO> list() throws Exception {
		return dao.list();
	}

}
