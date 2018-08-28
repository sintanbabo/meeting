package com.sintanbabo.meeting.model;

import java.util.Date;

public class Meeting {

	private String meetingRoomName;
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
