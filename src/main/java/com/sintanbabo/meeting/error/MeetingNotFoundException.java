package com.sintanbabo.meeting.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Order")
public class MeetingNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public MeetingNotFoundException() {
		super();
	}
	public MeetingNotFoundException(String message) {
		super(message);
	}
}
