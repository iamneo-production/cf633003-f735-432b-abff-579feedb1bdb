package com.hackathon.appointmentschedularservice.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Date {
    private LocalDate date;
    private String time;
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date(LocalDate date, String time) {
		super();
		this.date = date;
		this.time = time;
	}
	public Date() {}
	@Override
	public String toString() {
		return "Date [date=" + date + ", time=" + time + "]";
	}
}
