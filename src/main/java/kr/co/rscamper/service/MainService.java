package kr.co.rscamper.service;

import kr.co.rscamper.domain.MainVO;

public interface MainService {
	public String getTime() throws Exception;
	public void insertMainComment(MainVO vo) throws Exception;
}
