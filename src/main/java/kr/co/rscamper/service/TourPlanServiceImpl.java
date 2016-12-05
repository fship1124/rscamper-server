package kr.co.rscamper.service;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.TourPlanCoverVO;
import kr.co.rscamper.domain.TourPlanParamVO;
import kr.co.rscamper.domain.TourPlanScheduleVO;
import kr.co.rscamper.domain.TourPlanSpotParamVO;
import kr.co.rscamper.domain.TourPlanVO;
import kr.co.rscamper.domain.UserPhotoVO;
import kr.co.rscamper.domain.UserVO;
import kr.co.rscamper.domain.TourPlanSpotVO;
import kr.co.rscamper.persistence.TourPlanDAO;

@Service
public class TourPlanServiceImpl implements TourPlanService {
	
	@Inject
	private TourPlanDAO dao;

	@Override
	public  Map<String, Object> selectTourPlanList(TourPlanParamVO tourPlanParam) {
		// 검색범위 날짜 객채 생성
		tourPlanParam.setDatePeriodDate(new Date(new Date().getTime() - ((long) 24 * 60 * 60 * 1000 * tourPlanParam.getDatePeriod())));
		
		// 페이징 처리
		tourPlanParam.setStartRow((tourPlanParam.getPageNo() - 1) * tourPlanParam.getAmount());
		int totalPages = (int) Math.ceil((double) dao.selectTourPlanTotalPages(tourPlanParam) / (double) tourPlanParam.getAmount());
	
		// 리스트 받아오기
		List<TourPlanVO> tourPlanList = dao.selectTourPlanList(tourPlanParam);
		
		Map<String, Object> tourPlanMap = new HashMap<>();
		tourPlanMap.put("tourPlanList", tourPlanList);
		tourPlanMap.put("totalPages", totalPages);
		return tourPlanMap;
	}

	@Override
	public int insertTourPlan(TourPlanVO tourPlan) {
		tourPlan.setPeriod(getDate( tourPlan.getDepartureDate(), tourPlan.getArriveDate()));
		return dao.insertTourPlan(tourPlan);
	}
	
	public String getDate(Date dDate, Date aDate) {
		String d = "";
		long nTime = aDate.getTime() - dDate.getTime();
		long year = nTime/1000/60/60/24/365;
		long day = nTime/1000/60/60/24;
		if (year == 0 && day >= 1) {
			long duty = day + 1;
			d = day + "박" + duty + "일";
		} else {
			d = "1일";
		}
		return d;
	}

	@Override
	public Map<String, Object> selectSpotList(TourPlanSpotParamVO tourPlanSpotParam) {
		tourPlanSpotParam.setStartRow((tourPlanSpotParam.getPageNo() - 1) * tourPlanSpotParam.getAmount());

		int totalPages = (int) Math.ceil((double) dao.selectSpotTotalPages(tourPlanSpotParam) / (double) tourPlanSpotParam.getAmount());
		List<TourPlanSpotVO> tourSpotList = dao.selectTourSpotList(tourPlanSpotParam);

		Map<String, Object> tourSpotMap = new HashMap<>();
		tourSpotMap.put("tourSpotList", tourSpotList);
		tourSpotMap.put("totalPages", totalPages);
		return tourSpotMap;
	}

	@Override
	public TourPlanVO selectTourPlan(int recordNo) {
		return dao.selectTourPlan(recordNo);
	}

	@Override
	public void updateCoverImage(TourPlanCoverVO tourPlanCover) {
		System.out.println("배경이미지수정 : " + tourPlanCover.toString());
		
		// 이전에 있던 파일 정보 가져오기
		TourPlanCoverVO oldTourPlanCover = dao.selectTourPlanCoverByNo(tourPlanCover.getRecordNo());
		if (oldTourPlanCover != null) {
			String oldPath = oldTourPlanCover.getRealPath();
			
			File f = new File(oldPath);
			f.delete();
			
			// DB에 커버사진 파일 정보 지우기
			dao.deleteTourPlanCoverByNo(oldTourPlanCover.getCoverNo());
		}

		// 사진 정보 입력하고 키값 리턴 받기
		dao.insertTourPlanCover(tourPlanCover);
		System.out.println("커버넘버 : " + tourPlanCover.getCoverNo());
		
		// 리턴받은 키값과 picture=1로 수정
		TourPlanVO tourPlan = new TourPlanVO();
		tourPlan.setRecordNo(tourPlanCover.getRecordNo());
		tourPlan.setPicture(1);
		
		dao.updateTourPlanImgByNo(tourPlan);
	}

	@Override
	public void updateTourPlanTitle(TourPlanVO tourPlan) {
		dao.updateTourPlanTitle(tourPlan);
	}

	@Override
	public void updateTourPlan(TourPlanVO tourPlan) {
		System.out.println("일정정보 : " + tourPlan.toString());
		dao.updateTourPlan(tourPlan);
	}

	@Override
	public void insertTourPlanSchedule(TourPlanScheduleVO tourPlanSchedule) {
		System.out.println("일정스케쥴정보 : " + tourPlanSchedule.toString());
		dao.insertTourPlanSchedule(tourPlanSchedule);
	}

	@Override
	public void deleteTourPlanScheduleByRecordNo(int recordNo) {
		System.out.println("일정스케쥴 리스트 삭제");
		dao.deleteTourPlanScheduleByRecordNo(recordNo);
	}

	@Override
	public List<TourPlanScheduleVO> selectTourPlanScheduleListByRecordNo(int recordNo) {
		System.out.println("일정스케쥴 리스트 조회");
		return dao.selectTourPlanScheduleListByRecordNo(recordNo);
	}

	@Override
	public TourPlanSpotVO selectSpotDetail(int contentid) {
		return dao.selectSpotDetail(contentid);
	}

}
