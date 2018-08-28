package com.sintanbabo.meeting.service;

import java.util.HashMap;
import java.util.List;

import com.sintanbabo.meeting.model.Meeting;
import com.sintanbabo.meeting.model.MeetingList;

public interface MeetingService {
	// 회의실 예약
	void save(Meeting meeting) throws Exception;

	// 회의실 예약 세부 확인
	Meeting get(HashMap<String,Object> map) throws Exception;

	// 회의실 예약 확인
	List<MeetingList> list(String date) throws Exception;

	// 회의실 예약 모두 확인
	List<Meeting> listAll() throws Exception;

	// 회의실 예약 변경
	void update(Meeting meeting) throws Exception;

	// 회의실 예약 취소
	void delete(HashMap<String,Object> map) throws Exception;
}
