package com.sintanbabo.meeting.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.sintanbabo.meeting.dao.MeetingDao;
import com.sintanbabo.meeting.log.Log;
import com.sintanbabo.meeting.model.Meeting;
import com.sintanbabo.meeting.model.MeetingList;

@Service
@Transactional(readOnly = true)
public class MeetingServiceImpl implements MeetingService {

	private static @Log Logger LOG;
	
	@Autowired
	private MeetingDao meetingDao;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;

	@Transactional
	@Override
	public void save(Meeting meeting) throws Exception {
		
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("save-transaction");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = transactionManager.getTransaction(def);

		try {
			// start 날짜 검증
			SimpleDateFormat dtStart = new SimpleDateFormat("yyyyMMddHHmmss");
			dtStart.setLenient(false);
			Date dateStart = dtStart.parse(meeting.getStart());
	
			// end 날짜 검증
			SimpleDateFormat dtEnd = new SimpleDateFormat("yyyyMMddHHmmss");
			dtEnd.setLenient(false);
			Date dateEnd = dtEnd.parse(meeting.getEnd());
	
			// end-start 가 30분 이상 차이가 있는지 확인
			long diff = (dateEnd.getTime() - dateStart.getTime()) / (1000 * 60);
			if (diff < 30)
				throw new Exception("start 와 end 시간 차이가 30분 미만 입니다.");
	
			// start 날짜 계산 
			Calendar calStart = Calendar.getInstance();
			calStart.setTime(dateStart);
			
			// end 날짜 계산
			Calendar calEnd = Calendar.getInstance();
			calEnd.setTime(dateEnd);
			
			//cycleCount 저장
			long total = meeting.getCycleCount();
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			int check = 0;
			
			if (total >= 0) {
				// start end 를 기준으로 중복된 회의실이 있는지 확인				
				map.put("start", meeting.getStart());
				map.put("end", meeting.getEnd());
				check = meetingDao.check(map);
				if (check > 0)
					throw new Exception("중복된 예약이 존재합니다.");
	
				meetingDao.save(meeting);
			}
			
			for (int i = 1; i <= total; i++) {
				
				// start 에 7일씩 더한다. (반복)
				calStart.add(Calendar.DATE, 7);
				meeting.setStart(dtStart.format(calStart.getTime()));
				
				// end 에 7일씩 더한다. (반복)
				calEnd.add(Calendar.DATE, 7);
				meeting.setEnd(dtEnd.format(calEnd.getTime()));
				
				// cycleCount 지정
				meeting.setCycleCount((long)i+1);
	
				// start end 를 기준으로 중복된 회의실이 있는지 확인
				map = new HashMap<String, Object>();
				map.put("start", meeting.getStart());
				map.put("end", meeting.getEnd());
				check = meetingDao.check(map);
				if (check > 0)
					throw new Exception("중복된 예약이 존재합니다.");
	
				meetingDao.save(meeting);
			}
			
			transactionManager.commit(status);
		}
		catch(Exception e) {
			transactionManager.rollback(status);
			throw e;
		}
	}

	@Override
	public Meeting get(HashMap<String, Object> map) throws Exception {
		return meetingDao.get(map);
	}

	@Override
	public List<MeetingList> list(String date) throws Exception {
		return meetingDao.list(date);
	}

	@Override
	public List<Meeting> listAll() throws Exception {
		return meetingDao.listAll();
	}

	@Transactional
	@Override
	public void update(Meeting meeting) throws Exception {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("update-transaction");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = transactionManager.getTransaction(def);

		try {
			meetingDao.update(meeting);
			transactionManager.commit(status);
		}
		catch(Exception e) {
			transactionManager.rollback(status);
			throw e;
		}
	}

	@Transactional
	@Override
	public void delete(HashMap<String, Object> map) throws Exception {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("delete-transaction");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = transactionManager.getTransaction(def);

		try {
			meetingDao.delete(map);
			transactionManager.commit(status);
		}
		catch(Exception e) {
			transactionManager.rollback(status);
			throw e;
		}
	}
}
