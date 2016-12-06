package kr.co.rscamper.service;

import java.util.List;

import kr.co.rscamper.domain.BenefitVO;
import kr.co.rscamper.domain.MainVO;
import kr.co.rscamper.domain.UserVO;

public interface MainService {
	public void insertMainComment(MainVO vo) throws Exception;
	public List<MainVO> selectMainComment() throws Exception;
	public List<BenefitVO> selectList(int benefitno)throws Exception;
}
