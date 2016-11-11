package kr.co.rscamper.domain;

import java.util.Date;

public class CommentVO {
	private Integer commentNo;
	private Integer targetCommentNo;
	private Integer boardNo;
	private String userUid;
	private String displayName;
	private String providerPhotoUrl;
	private String commentContent;
	private Date regDate;
	public Integer getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(Integer commentNo) {
		this.commentNo = commentNo;
	}
	public Integer getTargetCommentNo() {
		return targetCommentNo;
	}
	public void setTargetCommentNo(Integer targetCommentNo) {
		this.targetCommentNo = targetCommentNo;
	}
	public Integer getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}
	public String getUserUid() {
		return userUid;
	}
	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getProviderPhotoUrl() {
		return providerPhotoUrl;
	}
	public void setProviderPhotoUrl(String providerPhotoUrl) {
		this.providerPhotoUrl = providerPhotoUrl;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "CommentVO [commentNo=" + commentNo + ", targetCommentNo=" + targetCommentNo + ", boardNo=" + boardNo
				+ ", userUid=" + userUid + ", displayName=" + displayName + ", providerPhotoUrl=" + providerPhotoUrl
				+ ", commentContent=" + commentContent + ", regDate=" + regDate + "]";
	}
	
	
	
}
