package com.sintanbabo.meeting.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sintanbabo.meeting.model.Meeting;
import com.sintanbabo.meeting.model.MeetingList;
import com.sintanbabo.meeting.service.MeetingService;

@RestController
public class MeetingController {

	@Autowired
	private MeetingService meetingService;

	// Index Page
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
	
	// meeting Reservation Page
	@GetMapping("/meetingReservation")
	public ModelAndView meetingReservtion() {
		ModelAndView mav = new ModelAndView("meetingReservation");
		return mav;
	}
	
	// Meeting List
	@GetMapping("/meetingList")
	public ModelAndView meetingList() {
		ModelAndView mav = new ModelAndView("meetingList");
		return mav;
	}
	
	// 회의실 예약
	@PostMapping("/meeting")
	public ResponseEntity<?> save(@RequestBody Meeting meeting) throws Exception{
		meetingService.save(meeting);
		return ResponseEntity.ok().body("Meeting Reservation be saved successfully.");
	}

	// 회의실 예약 확인
	@GetMapping("/meeting/{meetingRoomName}/{start}/{end}")
	public ResponseEntity<Meeting> get(
			@PathVariable("meetingRoomName") String meetingRoomName,
			@PathVariable("start") String start,
			@PathVariable("end") String end) throws Exception {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("meetingRoomName", meetingRoomName);
		map.put("start", start);
		map.put("end", end);
		Meeting meeting = meetingService.get(map);
		return ResponseEntity.ok().body(meeting);
	}

	// 일자에 해당하는 회의실 예약 정보 확인
	@GetMapping("/meeting/{date}")
	public ResponseEntity<List<MeetingList>> list(@PathVariable("date") String date) throws Exception {
		List<MeetingList> meetingsList = meetingService.list(date);
		return ResponseEntity.ok().body(meetingsList);
	}

	// 일자와 상관없는 모든 회의실 예약 정보 확인
	@GetMapping("/meeting")
	public ResponseEntity<List<Meeting>> list() throws Exception {
		List<Meeting> meetings = meetingService.listAll();
		return ResponseEntity.ok().body(meetings);
	}

	// 회의실 예약 정보 수정
	@PutMapping("/meeting")
	public ResponseEntity<?> update(@RequestBody Meeting meeting) throws Exception {
		meetingService.update(meeting);
		return ResponseEntity.ok().body("Meeting Reservation has been updated successfully.");
	}

	// 회의실 예약 정보 삭제
	@DeleteMapping("/meeting/{meetingRoomName}/{start}/{end}")
	public ResponseEntity<?> delete(
			@PathVariable("meetingRoomName") String meetingRoomName,
			@PathVariable("start") String start,
			@PathVariable("end") String end) throws Exception {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("meetingRoomName", meetingRoomName);
		map.put("start", start);
		map.put("end", end);
		meetingService.delete(map);
		return ResponseEntity.ok().body("Meeting Reservation has been deleted successfully.");
	}
}
