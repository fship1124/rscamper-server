package kr.co.rscamper.domain;

import java.util.Date;

public class TourScheduleVO {
	private int recordNo;
	private String userUid;
	private Date departureDate;
	private Date arriveDate;
	private String title;
	private int budGet;
	private int picture;
	private String period;
	private RecordCoverVO cover;
	
	
	public RecordCoverVO getCover() {
		return cover;
	}
	public void setCover(RecordCoverVO cover) {
		this.cover = cover;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public int getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getArriveDate() {
		return arriveDate;
	}
	public void setArriveDate(Date arriveDate) {
		this.arriveDate = arriveDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getBudGet() {
		return budGet;
	}
	public void setBudGet(int budGet) {
		this.budGet = budGet;
	}
	public int getPicture() {
		return picture;
	}
	public void setPicture(int picture) {
		this.picture = picture;
	}
}
