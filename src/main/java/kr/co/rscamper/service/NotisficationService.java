package kr.co.rscamper.service;

import java.util.List;

import kr.co.rscamper.domain.NotisficationVO;

public interface NotisficationService {

	public List<NotisficationVO> list(String userUid) throws Exception;

}