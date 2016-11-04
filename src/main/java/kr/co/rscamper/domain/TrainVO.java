package kr.co.rscamper.domain;

public class TrainVO {

	private int stationNo;
	private String stationTitle;
	private int stationVital;
	public int getStationNo() {
		return stationNo;
	}
	public void setStationNo(int stationNo) {
		this.stationNo = stationNo;
	}
	public String getStationTitle() {
		return stationTitle;
	}
	public void setStationTitle(String stationTitle) {
		this.stationTitle = stationTitle;
	}
	public int getStationVital() {
		return stationVital;
	}
	public void setStationVital(int stationVital) {
		this.stationVital = stationVital;
	}
	@Override
	public String toString() {
		return "TrainVO [stationNo=" + stationNo + ", stationTitle=" + stationTitle + ", stationVital=" + stationVital
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
