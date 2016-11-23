package kr.co.rscamper.persistence;

import java.util.List;

import kr.co.rscamper.domain.TourPlanParamVO;
import kr.co.rscamper.domain.TourPlanSpotParamVO;
import kr.co.rscamper.domain.TourPlanVO;
import kr.co.rscamper.domain.TourPlanSpotVO;

public interface TourPlanDAO {

	/** 여행일정 메인 조회 */
	public List<TourPlanVO> selectTourPlanList(TourPlanParamVO tourPlanParam);

	/** 여행일정 총 개수 조회 */
	public int selectTourPlanTotalPages(TourPlanParamVO tourPlanParam);

	/** 여행일정 신규 등록 */
	public void insertTourPlan(TourPlanVO tourPlan);

	/** 여행장소 총 개수 조회 */
	public int selectSpotTotalPages(TourPlanSpotParamVO tourPlanSpotParam);

	/** 여행장소 리스트 조회 */
	public List<TourPlanSpotVO> selectTourSpotList(TourPlanSpotParamVO tourPlanSpotParam);
	
}
