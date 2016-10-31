package kr.co.rscamper.domain;

import java.util.Date;

public class PostVO {

	private int boardNo;
	private int categoryNo;
	private String title;
	private String userUid;
	private int viewCnt;
	private Date regDate;
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "PostVO [boardNo=" + boardNo + ", categoryNo=" + categoryNo + ", title=" + title + ", userUid=" + userUid
				+ ", viewCnt=" + viewCnt + ", regDate=" + regDate + "]";
	}
	
	
}
