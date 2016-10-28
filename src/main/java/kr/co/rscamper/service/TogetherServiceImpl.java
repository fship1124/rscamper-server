package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.MainVO;
import kr.co.rscamper.domain.TogetherVO;
import kr.co.rscamper.persistence.TogetherDAO;

@Service
public class TogetherServiceImpl implements TogetherService {

	@Inject
	private TogetherDAO dao;
	
	
	@Override
	public List<TogetherVO> selectTogether() throws Exception {
		return dao.selectTogether();
	}

}
