package com.hackathon.appointmentstatusservice.exception;

public class DuplicateException extends RuntimeException {
	public DuplicateException(String str) {
		super(str);
	}
}