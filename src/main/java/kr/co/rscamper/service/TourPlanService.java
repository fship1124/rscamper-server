package kr.co.rscamper.service;

import java.util.Map;

import kr.co.rscamper.domain.TourPlanParamVO;
import kr.co.rscamper.domain.TourPlanSpotParamVO;
import kr.co.rscamper.domain.TourPlanVO;

public interface TourPlanService {

	/** 여행일정 리스트 가져오기 */
	public Map<String, Object> selectTourPlanList(TourPlanParamVO tourPlanParam);

	/** 여행일정 신규 작성 */
	public void insertTourPlan(TourPlanVO tourPlan);

	/** 장소정보 리스트 가져오기 */
	public Map<String, Object> selectSpotList(TourPlanSpotParamVO tourPlanSpotParam);
	
}
