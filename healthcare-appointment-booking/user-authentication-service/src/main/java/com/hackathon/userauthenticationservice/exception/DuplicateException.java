package com.hackathon.userauthenticationservice.exception;

public class DuplicateException extends RuntimeException {
	public DuplicateException(String str) {
		super(str);
	}
}