package kr.co.rscamper.domain;

public class ChatRoomVO {
	private int chatRoomInfoNo;
	private String chatRoomName;
	private int areacode;
	private String chatRoomLive;
	private String areaName;
	private int roomUserCnt;
	public int getChatRoomInfoNo() {
		return chatRoomInfoNo;
	}
	public void setChatRoomInfoNo(int chatRoomInfoNo) {
		this.chatRoomInfoNo = chatRoomInfoNo;
	}
	public String getChatRoomName() {
		return chatRoomName;
	}
	public void setChatRoomName(String chatRoomName) {
		this.chatRoomName = chatRoomName;
	}
	public int getAreacode() {
		return areacode;
	}
	public void setAreacode(int areacode) {
		this.areacode = areacode;
	}
	public String getChatRoomLive() {
		return chatRoomLive;
	}
	public void setChatRoomLive(String chatRoomLive) {
		this.chatRoomLive = chatRoomLive;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public int getRoomUserCnt() {
		return roomUserCnt;
	}
	public void setRoomUserCnt(int roomUserCnt) {
		this.roomUserCnt = roomUserCnt;
	}
	@Override
	public String toString() {
		return "ChatRoomVO [chatRoomInfoNo=" + chatRoomInfoNo + ", chatRoomName=" + chatRoomName + ", areacode="
				+ areacode + ", chatRoomLive=" + chatRoomLive + ", areaName=" + areaName + ", roomUserCnt="
				+ roomUserCnt + "]";
	}
	
}
