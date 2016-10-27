package kr.co.rscamper.service;

import java.util.List;

import kr.co.rscamper.domain.MainVO;
import kr.co.rscamper.domain.UserVO;

public interface MainService {
	public String getTime() throws Exception;
	public void insertMainComment(MainVO vo) throws Exception;
	public List<MainVO> selectMainComment() throws Exception;
}
