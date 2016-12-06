package kr.co.rscamper.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.BenefitVO;
import kr.co.rscamper.domain.MainVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.persistence.MainDAO;

@Service
public class MainServiceImpl implements MainService {
	
	@Inject
	private MainDAO dao;
	
	@Override
	public void insertMainComment(MainVO vo) throws Exception {
		dao.insertMainComment(vo);
	}

	@Override
	public List<MainVO> selectMainComment() throws Exception {
		return dao.selectMainComment();
	}

	@Override
	public List<BenefitVO> list() throws Exception {
		return dao.list();
	}



}
