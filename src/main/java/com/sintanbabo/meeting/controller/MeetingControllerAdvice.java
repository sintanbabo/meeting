package com.sintanbabo.meeting.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sintanbabo.meeting.error.MeetingNotFoundException;

@ControllerAdvice
public class MeetingControllerAdvice {

	@ExceptionHandler(Exception.class)
	public String handleException(Exception exception, Model model) {
		model.addAttribute("exception", exception);
		return "exception-page";
	}
	
	@ExceptionHandler(MeetingNotFoundException.class)
	public String handelMettingNotFoundException(Exception exception, Model model) {
		model.addAttribute("exception", exception);
		return "exception-page";
	}
}
