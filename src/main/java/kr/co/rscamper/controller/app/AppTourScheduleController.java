package kr.co.rscamper.controller.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.rscamper.domain.RecordCoverVO;
import kr.co.rscamper.domain.TourScheduleVO;
import kr.co.rscamper.service.TourScheduleService;

@Controller
@RequestMapping("/app/tourschedule")
public class AppTourScheduleController {

	@Inject
	private TourScheduleService service;
	
	@RequestMapping("/getschedule")
	@ResponseBody
	public List<TourScheduleVO> getScheduleList(String uid) throws Exception {
		List<TourScheduleVO> tList = new ArrayList<>();
		tList = service.getSchedule(uid);
		for (TourScheduleVO ts : tList) {
			if (ts.getPicture() == 1) {
				ts.setCover(service.getCover(ts.getRecordNo()));
			}
		}
		return tList;
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public List<TourScheduleVO> insertTourSchedule(String uid, String title, String sDate, String fDate) throws Exception {
		TourScheduleVO tv = new TourScheduleVO();
		System.out.println("스케줄등록");
		tv.setUserUid(uid);
		tv.setTitle(title);
		tv.setDepartureDate(parseDate(sDate));
		tv.setArriveDate(parseDate(fDate));
		tv.setPeriod(getDate(tv.getDepartureDate(), tv.getArriveDate()));
		service.insertSchedule(tv);
		return getScheduleList(uid);
	}
	
	public Date parseDate(String date) throws Exception {
		String parseDay[] = date.split("T");
		String date1[] = parseDay[0].split("-"); 
		int day = Integer.parseInt(date1[2]) + 1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		return sdf.parse(date1[0] + "-" + date1[1] + "-" + day);
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
		System.out.println(d);
		return d;
	}
	
	@RequestMapping("/getTourDate")
	@ResponseBody
	public List<String> getTourDate(long dDate, long aDate) throws Exception {
		long nTime = aDate - dDate;
		long day = 1000 * 60 * 60 * 24;
		int period = (int) (nTime/day);
		List<String> dayList = new ArrayList<>();
		dayList.add(getWeek(new Date(dDate)));
		long nextDay = dDate + day;
		while (aDate >= nextDay) {
			dayList.add(getWeek(new Date(nextDay)));
			nextDay = nextDay + day;
		}
		return dayList;
	}
	
	public String getWeek(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy. MM. dd.");
		String dayText = sdf.format(d);
		switch (d.getDay()) {
		case 0: dayText = dayText +  "(일)"; break;
		case 1: dayText = dayText +  "(월)"; break;
		case 2: dayText = dayText +  "(화)"; break;
		case 3: dayText = dayText +  "(수)"; break;
		case 4: dayText = dayText +  "(목)"; break;
		case 5: dayText = dayText +  "(금)"; break;
		case 6: dayText = dayText +  "(토)"; break;
		}
		return dayText;
	}
	
	@RequestMapping("/delSchedule")
	@ResponseBody
	public List<TourScheduleVO> delSchedule(String uid, int no) throws Exception {
		service.delSchedule(no);
		return getScheduleList(uid);
	}
	
	@RequestMapping("/changeCover")
	@ResponseBody
	public TourScheduleVO changeCover(int no, int isPhoto, String photo) throws Exception {
		System.out.println("Asdasd");
		RecordCoverVO rc = new RecordCoverVO();
		rc.setRecordNo(no);
		rc.setFilePath(photo);
		if (isPhoto == 0) {
			service.insertCover(rc);
		} else {
			service.changeCover(rc);
		}
		TourScheduleVO tv = service.getDetailTourSchedule(no);
		tv.setCover(service.getCover(no));
		return tv;
	}
	
}
