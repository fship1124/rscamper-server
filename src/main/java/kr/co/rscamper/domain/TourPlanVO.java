package kr.co.rscamper.domain;

import java.util.Date;

public class TourPlanVO {

	private int recordNo;
	private String userUid;
	private Date departureDate;
	private Date arriveDate;
	private String title;
	private int budGet;
	private int picture;
	private String period;
	private RecordCoverVO cover;
	private String strapline;
	private String introduce;
	private Date regDate;
	
	private int likeCnt;
	private int commentCnt;
	private int locationCnt;
	private int postCnt;
	
	
	private String displayName;
	
	private int totalPages;
	
	
	@Override
	public String toString() {
		return "TourPlanVO [recordNo=" + recordNo + ", userUid=" + userUid + ", departureDate=" + departureDate
				+ ", arriveDate=" + arriveDate + ", title=" + title + ", budGet=" + budGet + ", picture=" + picture
				+ ", period=" + period + ", cover=" + cover + ", strapline=" + strapline + ", introduce=" + introduce
				+ ", regDate=" + regDate + ", likeCnt=" + likeCnt + ", commentCnt=" + commentCnt + ", locationCnt="
				+ locationCnt + ", postCnt=" + postCnt + ", displayName=" + displayName + ", totalPages=" + totalPages
				+ "]";
	}


	public int getPostCnt() {
		return postCnt;
	}


	public void setPostCnt(int postCnt) {
		this.postCnt = postCnt;
	}


	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public int getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	public int getLocationCnt() {
		return locationCnt;
	}
	public void setLocationCnt(int locationCnt) {
		this.locationCnt = locationCnt;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getStrapline() {
		return strapline;
	}
	public void setStrapline(String strapline) {
		this.strapline = strapline;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}	
	public RecordCoverVO getCover() {
		return cover;
	}
	public void setCover(RecordCoverVO cover) {
		this.cover = cover;
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
