package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
	public List<TravelogVO> listTravelog(PageVO vo) throws Exception {
		return dao.listTravelog(vo);
	}

	@Override
	public int totalCount() throws Exception {
		return dao.totalCount();
	}

	
	@Override
	public void regist(TravelogVO travelog) throws Exception {
		dao.insertTravelog(travelog);
	}

	
}
