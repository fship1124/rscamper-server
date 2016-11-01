package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
	public List<TravelogVO> listAll() throws Exception {
		return dao.listAllTravelog();
	}

	@Override
	public void regist(TravelogVO travelog) throws Exception {
		dao.insertTravelog(travelog);
	}

	
}
