package kr.co.rscamper.domain;

import java.util.Date;

public class TourPlanVO {

	// 기본정보
	private int recordNo;
	private String userUid;
	private Date departureDate;
	private Date arriveDate;
	private String title;
	private int budget;
	private int picture;
	private String period;
	private String strapline;
	private String introduce;
	private Date regDate;
	private int isOpen;
	
	// 카운트
	private int likeCnt;
	private int commentCnt;
	private int locationCnt;
	private int postCnt;


	// 유저정보
	private String displayName;
	private String photoUrl;
	
	// 배경화면 이미지 정보
	private String filePath;
	
	// 페이징
	private int totalPages;
	

	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getIsOpen() {
		return isOpen;
	}


	public void setIsOpen(int isOpen) {
		this.isOpen = isOpen;
	}


	public String getPhotoUrl() {
		return photoUrl;
	}


	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
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
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public int getPicture() {
		return picture;
	}
	public void setPicture(int picture) {
		this.picture = picture;
	}


	@Override
	public String toString() {
		return "TourPlanVO [recordNo=" + recordNo + ", userUid=" + userUid + ", departureDate=" + departureDate
				+ ", arriveDate=" + arriveDate + ", title=" + title + ", budget=" + budget + ", picture=" + picture
				+ ", period=" + period + ", strapline=" + strapline + ", introduce=" + introduce + ", regDate="
				+ regDate + ", likeCnt=" + likeCnt + ", commentCnt=" + commentCnt + ", locationCnt=" + locationCnt
				+ ", postCnt=" + postCnt + ", displayName=" + displayName + ", filePath=" + filePath + ", totalPages="
				+ totalPages + "]";
	}

	
	
}
