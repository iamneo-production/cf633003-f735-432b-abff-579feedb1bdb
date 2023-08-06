package com.apigatway.exception;

public class DataNotFoundException extends RuntimeException {
	public DataNotFoundException(String str) {
		super(str);
	}
}
