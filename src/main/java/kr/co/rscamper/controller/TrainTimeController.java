package kr.co.rscamper.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.rscamper.domain.TrainVO;
import kr.co.rscamper.service.TrainService;

@RestController
@RequestMapping("/trainTime/*")
public class TrainTimeController {
	
	private static final Logger logger = LoggerFactory.getLogger(TrainTimeController.class);
	
	@Inject
	private TrainService service;
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String trainTime() {
		logger.info("/trainTime > home");
		
		return "redirect:http://localhost:80/rscamper-web/views/train/trainTimeList.jsp";
	}
	
	
	/**
	 * 열차 시간정보 목록
	 */
	
	@RequestMapping(value="/trainTimeList", method = RequestMethod.GET)
	public @ResponseBody List<TrainVO> list() throws Exception {
		logger.info("trainTime");
	//	System.out.println("들어옴");
		List<TrainVO> list = new ArrayList<>();
		list = service.list();
		return list;
	}
	
	
	@RequestMapping(value="/time", method = RequestMethod.GET)
	public StringBuilder api(@RequestParam("trainGradeCode") String trainGradeCode)throws Exception {
		System.out.println("trainTime > time");
		System.out.print("trainGradeCode : ");
		System.out.println(trainGradeCode);
		System.out.println("rrrrrr");
//		System.out.println(train.toString());
//        StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/TrainInfoService/getStrtpntAlocFndTrainInfo"); /*URL*/
//        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=XPIlh8%2Bq3M1vpyrwOfH512edOBZMsZD0%2F3xZvjEd42mwMNJqeouD9L6xCPpzyF70KYm078jOK%2FePGlyoXTbCDw%3D%3D"); /*Service Key*/
//        urlBuilder.append("&depPlaceId=" + (train.getTrainId() == null ? "" : train.getTrainId())); /*출발역*/
//        urlBuilder.append("&arrPlaceId=" + (train.getTrainId() == null ? "" : train.getTrainId())); /*도착역*/
//        urlBuilder.append("&depPlandTime" + (train.getRegDate() == null ? "" : train.getRegDate())); /*날짜*/
//        urlBuilder.append("&trainGradeCode" + (train.getTrainGradeCode() == null ? "" : train.getTrainGradeCode())); /*열차번호*/
//        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("999", "UTF-8")); /*검색건수*/
//        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
//        urlBuilder.append("&_type=json");
//        URL url = new URL(urlBuilder.toString());
//        System.out.println(url);
//        
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Content-type", "application/json");
//        System.out.println("Response code: " + conn.getResponseCode());
//        BufferedReader rd;
//        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        } else {
//            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//        }
//        StringBuilder sb = new StringBuilder();
//        String line;
//        while ((line = rd.readLine()) != null) {
//            sb.append(line);
//        }
//        rd.close();
//        conn.disconnect();
//        System.out.println(sb.toString());
		
		
		
		return null;
		
	}
	
	
	
}
