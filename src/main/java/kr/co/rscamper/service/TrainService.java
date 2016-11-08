package kr.co.rscamper.service;

import java.util.List;

import kr.co.rscamper.domain.TrainVO;

public interface TrainService {

	public List<TrainVO> list()throws Exception;
}
