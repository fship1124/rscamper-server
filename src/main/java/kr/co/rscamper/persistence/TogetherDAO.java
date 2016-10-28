package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.MainVO;
import kr.co.rscamper.domain.TogetherVO;

public interface TogetherDAO {

	public List<TogetherVO> selectTogether() throws Exception;

}
