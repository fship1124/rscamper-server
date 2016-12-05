package kr.co.rscamper.service;

import java.util.List;
import java.util.Map;

import kr.co.rscamper.domain.TourPlanCoverVO;
import kr.co.rscamper.domain.TourPlanParamVO;
import kr.co.rscamper.domain.TourPlanScheduleVO;
import kr.co.rscamper.domain.TourPlanSpotParamVO;
import kr.co.rscamper.domain.TourPlanSpotVO;
import kr.co.rscamper.domain.TourPlanVO;

public interface TourPlanService {

	/** 여행일정 리스트 가져오기 */
	public Map<String, Object> selectTourPlanList(TourPlanParamVO tourPlanParam);

	/** 여행일정 신규 작성 */
	public int insertTourPlan(TourPlanVO tourPlan);

	/** 장소정보 리스트 가져오기 */
	public Map<String, Object> selectSpotList(TourPlanSpotParamVO tourPlanSpotParam);

	/** 여행일정 한개 가져오기 */
	public TourPlanVO selectTourPlan(int recordNo);

	/** 여행일정 - 커버 이미지 수정 */
	public void updateCoverImage(TourPlanCoverVO tourPlanCover);

	/** 여행일정 - 제목 수정 */
	public void updateTourPlanTitle(TourPlanVO tourPlan);

	/** 여행일정 수정 */
	public void updateTourPlan(TourPlanVO tourPlan);

	/** 여행일정 - 스케쥴 리스트 등록 */
	public void insertTourPlanSchedule(TourPlanScheduleVO tourPlanSchedule);

	/** 여행일정 - 스케쥴 리스트 삭제 */
	public void deleteTourPlanScheduleByRecordNo(int recordNo);

	/** 여행일정 - 스케쥴 리스트 가져오기 */
	public List<TourPlanScheduleVO> selectTourPlanScheduleListByRecordNo(int recordNo);

	/** 장소정보 디테일 가져오기*/
	public TourPlanSpotVO selectSpotDetail(int contentid);

}
