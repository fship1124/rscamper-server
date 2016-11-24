package kr.co.rscamper.controller;

import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.TourPlanParamVO;
import kr.co.rscamper.domain.TourPlanSpotParamVO;
import kr.co.rscamper.domain.TourPlanVO;
import kr.co.rscamper.service.TourPlanService;

@Controller
@RequestMapping("/tourPlan")
public class TourPlanController {

	private static final Logger logger = LoggerFactory.getLogger(TourPlanController.class);
	
	@Inject
	private TourPlanService tourPlanService;
	
	@RequestMapping(value = "/select/tourPlanList", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> selectTourPlanList(TourPlanParamVO tourPlanParam) throws Exception {
		return tourPlanService.selectTourPlanList(tourPlanParam);
	}
	
	@RequestMapping(value = "/insert/tourPlan", method = RequestMethod.POST)
	public @ResponseBody int insertTourPlan(TourPlanVO tourPlan) throws Exception {
		return tourPlanService.insertTourPlan(tourPlan);
	}
	
	@RequestMapping(value = "/select/spotList", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> selectSpotList(TourPlanSpotParamVO tourPlanSpotParam) throws Exception {
		return tourPlanService.selectSpotList(tourPlanSpotParam);
	}
	
	@RequestMapping(value = "/select/oneTourPlan", method = RequestMethod.GET)
	public @ResponseBody TourPlanVO selectTourPlan(int recordNo) throws Exception {
		return tourPlanService.selectTourPlan(recordNo);
	}
	
	
	
	

}