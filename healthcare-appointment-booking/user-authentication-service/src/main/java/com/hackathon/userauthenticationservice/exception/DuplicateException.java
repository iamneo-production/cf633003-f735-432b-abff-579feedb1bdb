package com.hackathon.userauthenticationservice.exception;

public class DuplicateException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DuplicateException(String str) {
		super(str);
	}
}