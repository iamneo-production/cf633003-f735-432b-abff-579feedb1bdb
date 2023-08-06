package com.apigatway.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorInfo {
	LocalDateTime timestamp;
	String msg;
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ErrorInfo(LocalDateTime timestamp, String msg) {
		super();
		this.timestamp = timestamp;
		this.msg = msg;
	}
	public ErrorInfo() {}
	@Override
	public String toString() {
		return "ErrorInfo [timestamp=" + timestamp + ", msg=" + msg + "]";
	}
}
