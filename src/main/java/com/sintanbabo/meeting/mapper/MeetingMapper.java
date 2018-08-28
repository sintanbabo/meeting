package com.sintanbabo.meeting.mapper;

import java.util.HashMap;
import java.util.List;

import com.sintanbabo.meeting.model.Meeting;
import com.sintanbabo.meeting.model.MeetingList;

public interface MeetingMapper {
	// 회의실 예약
	int save(Meeting metting);

	// 회의실 예약 세부 확인
	Meeting get(HashMap<String,Object> map);
	
	// 중복된 예약 확인
	int check(HashMap<String,Object> map);

	// 회의실 예약 확인
	List<MeetingList> list(String date);

	// 회의실 예약 모두 확인
	List<Meeting> listAll();

	// 회의실 예약 변경
	void update(Meeting metting);

	// 회의실 예약 취소
	void delete(HashMap<String,Object> map);
}