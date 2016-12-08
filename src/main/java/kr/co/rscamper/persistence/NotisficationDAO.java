package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.NotisficationVO;

public interface NotisficationDAO {

	public List<NotisficationVO> list(String userUid) throws Exception;

}
