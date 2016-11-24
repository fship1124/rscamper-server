package kr.co.rscamper.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.rscamper.domain.TourPlanParamVO;
import kr.co.rscamper.domain.TourPlanSpotParamVO;
import kr.co.rscamper.domain.TourPlanVO;
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
	
}
