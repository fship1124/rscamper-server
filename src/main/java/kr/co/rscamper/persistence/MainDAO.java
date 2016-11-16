package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.MainVO;
import kr.co.rscamper.domain.UserVO;

public interface MainDAO {
	
	public void insertMainComment(MainVO vo);
	public List<MainVO> selectMainComment();
}
