package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.TrainVO;

public interface TrainDAO {
	
	public List<TrainVO> list()throws Exception;
}
