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
	
	// 카운트(좋아요 북마크 일정복사 댓글수)
	private int likeCnt;
	private int bookmarkCnt;
	private int customCnt;
	private int commentCnt;



	// 유저정보
	private String displayName;
	
	// 배경화면 이미지 정보
	private String filePath;
	
	// 페이징
	private int totalPages;
	

	public int getCustomCnt() {
		return customCnt;
	}


	public void setCustomCnt(int customCnt) {
		this.customCnt = customCnt;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
	public int getPicture() {
		return picture;
	}
	public void setPicture(int picture) {
		this.picture = picture;
	}


	public int getBudget() {
		return budget;
	}

	public int getBookmarkCnt() {
		return bookmarkCnt;
	}


	public void setBookmarkCnt(int bookmarkCnt) {
		this.bookmarkCnt = bookmarkCnt;
	}


	public void setBudget(int budget) {
		this.budget = budget;
	}



	
	
}
