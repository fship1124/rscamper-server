package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.NotisficationVO;
import kr.co.rscamper.persistence.NotisficationDAO;

@Service
public class NotisficationServiceImpl implements NotisficationService {
	@Inject
	private NotisficationDAO dao;
	
	
	@Override
	public List<NotisficationVO> list(String userUid) throws Exception {
		return dao.list(userUid);
	}

}
