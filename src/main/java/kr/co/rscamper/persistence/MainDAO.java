package kr.co.rscamper.persistence;

import kr.co.rscamper.domain.MainVO;

public interface MainDAO {
	
	public String getTime();
	public void insertMainComment(MainVO vo);
}
