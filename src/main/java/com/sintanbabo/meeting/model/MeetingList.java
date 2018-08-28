package com.sintanbabo.meeting.model;

public class MeetingList {
	private String meetingRoomName;
	private String date;
	private String gubun;
	private String start;
	private String end;
	private String user;
	private Long cycleCount;

	public String getMettingRoomName() {
		return meetingRoomName;
	}

	public void setMettingRoomName(String meetingRoomName) {
		this.meetingRoomName = meetingRoomName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Long getCycleCount() {
		return cycleCount;
	}

	public void setCycleCount(Long cycleCount) {
		this.cycleCount = cycleCount;
	}

}
