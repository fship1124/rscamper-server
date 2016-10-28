package kr.co.rscamper.service;

import java.util.List;

import kr.co.rscamper.domain.MainVO;
import kr.co.rscamper.domain.TogetherVO;

public interface TogetherService {

	public List<TogetherVO> selectTogether() throws Exception;
	
}
