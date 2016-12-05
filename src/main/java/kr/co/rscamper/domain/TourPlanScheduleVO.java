package kr.co.rscamper.domain;

public class TourPlanScheduleVO {
	
	private int locationNo;
	private int recordNo;
	private String title;
	private int contentCode;
	private String imageUrl;
	private String detailDepartureDate;
	private String detailArriveDate;
	private String departureDate;
	private int contentTypeId;
	private String mapX;
	private String mapY;
	
	@Override
	public String toString() {
		return "TourPlanScheduleVO [locationNo=" + locationNo + ", recordNo=" + recordNo + ", title=" + title
				+ ", contentCode=" + contentCode + ", imageUrl=" + imageUrl + ", detailDepartureDate="
				+ detailDepartureDate + ", detailArriveDate=" + detailArriveDate + ", departureDate=" + departureDate
				+ ", contentTypeId=" + contentTypeId + ", mapX=" + mapX + ", mapY=" + mapY + "]";
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getContentCode() {
		return contentCode;
	}
	public void setContentCode(int contentCode) {
		this.contentCode = contentCode;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getDetailDepartureDate() {
		return detailDepartureDate;
	}
	public void setDetailDepartureDate(String detailDepartureDate) {
		this.detailDepartureDate = detailDepartureDate;
	}
	public String getDetailArriveDate() {
		return detailArriveDate;
	}
	public void setDetailArriveDate(String detailArriveDate) {
		this.detailArriveDate = detailArriveDate;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public int getContentTypeId() {
		return contentTypeId;
	}
	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}
	public String getMapX() {
		return mapX;
	}
	public void setMapX(String mapX) {
		this.mapX = mapX;
	}
	public String getMapY() {
		return mapY;
	}
	public void setMapY(String mapY) {
		this.mapY = mapY;
	}
	
	
}
