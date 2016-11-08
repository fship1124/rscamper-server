/* 
 * 메인 - 실시간 정보 공유 DTO 
 */
package kr.co.rscamper.domain;

import java.util.Date;

public class MainVO {
	private String userUid;
	private String displayName;
	private String providerPhotoUrl;
	private String mainContent;
	private Date mainRegDate;
	
	
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
	public String getMainContent() {
		return mainContent;
	}
	public void setMainContent(String mainContent) {
		this.mainContent = mainContent;
	}
	public Date getMainRegDate() {
		return mainRegDate;
	}
	public void setMainRegDate(Date mainRegDate) {
		this.mainRegDate = mainRegDate;
	}
	
	
	@Override
	public String toString() {
		return "MainVO [userUid=" + userUid + ", displayName=" + displayName + ", providerPhotoUrl=" + providerPhotoUrl
				+ ", mainContent=" + mainContent + ", mainRegDate=" + mainRegDate + "]";
	}
}
