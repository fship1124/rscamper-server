package kr.co.rscamper.domain;

import java.util.Date;

public class TourPlanSpotMemoVO {
	
	private int locationMemoNo;
	private int locationNo;
	private int recordNo;
	private int memoType;
	private String userUid;
	private String title;
	private String content;
	private Date regDate;
	@Override
	public String toString() {
		return "TourPlanSpotMemoVO [locationMemoNo=" + locationMemoNo + ", locationNo=" + locationNo + ", recordNo="
				+ recordNo + ", memoType=" + memoType + ", userUid=" + userUid + ", title=" + title + ", content="
				+ content + ", regDate=" + regDate + "]";
	}
	public int getLocationMemoNo() {
		return locationMemoNo;
	}
	public void setLocationMemoNo(int locationMemoNo) {
		this.locationMemoNo = locationMemoNo;
	}
	public int getLocationNo() {
		return locationNo;
	}
	public void setLocationNo(int locationNo) {
		this.locationNo = locationNo;
	}
	public int getRecordNo() {
		return recordNo;
	}
	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}
	public int getMemoType() {
		return memoType;
	}
	public void setMemoType(int memoType) {
		this.memoType = memoType;
	}
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
}

