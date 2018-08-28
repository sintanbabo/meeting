package com.sintanbabo.meeting.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sintanbabo.meeting.mapper.MeetingMapper;
import com.sintanbabo.meeting.model.Meeting;
import com.sintanbabo.meeting.model.MeetingList;

@Repository
public class MeetingDaoImpl implements MeetingDao {

	@Autowired
	private MeetingMapper meetingMapper;

	@Override
	public int save(Meeting meeting) {
		return meetingMapper.save(meeting);
	}

	@Override
	public Meeting get(HashMap<String,Object> map) {
		return meetingMapper.get(map);
	}
	
	@Override
	// 중복된 예약 확인
	public int check(HashMap<String,Object> map) {
		return meetingMapper.check(map);
	}

	@Override
	public List<MeetingList> list(String date) {
		List<MeetingList> result = new ArrayList<MeetingList>();
		result = meetingMapper.list(date);
		return result;
	}

	@Override
	public List<Meeting> listAll() {
		List<Meeting> result = new ArrayList<Meeting>();
		result = meetingMapper.listAll();
		return result;
	}

	@Override
	public void update(Meeting meeting) {
		meetingMapper.update(meeting);
	}

	@Override
	public void delete(HashMap<String,Object> map) {
		meetingMapper.delete(map);
	}	
}
