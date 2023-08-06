package com.hackathon.appointmentschedularservice.dto;
import java.sql.Date;



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
public class Date1 {
    private Date date;
    private String time;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date1(Date date, String time) {
		super();
		this.date = date;
		this.time = time;
	}
	public Date1() {}
	@Override
	public String toString() {
		return "Date [date=" + date + ", time=" + time + "]";
	}
}
