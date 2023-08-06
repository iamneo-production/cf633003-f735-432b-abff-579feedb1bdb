package com.hackathon.communicationservice.dto;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AppointmentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;
    private int patientId;
    private int providerId;
    private Date date;
    private String time;
    private Status status;
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public AppointmentStatus(int appointmentId, int patientId, int providerId, Date date, String time,
			Status status) {
		super();
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.providerId = providerId;
		this.date = date;
		this.time = time;
		this.status = status;
	}
	public AppointmentStatus() {}
	@Override
	public String toString() {
		return "AppointmentStatus [appointmentId=" + appointmentId + ", patientId=" + patientId + ", providerId="
				+ providerId + ", date=" + date + ", time=" + time + ", status=" + status + "]";
	}
	 public static Builder builder() {
	        return new Builder();
	    }
	public static class Builder {
        private int appointmentId;
        private int patientId;
        private int providerId;
        private Date date;
        private String time;
        private Status status;

        private Builder() {
            // Private constructor to be used only by the outer class.
        }

        public Builder appointmentId(int appointmentId) {
            this.appointmentId = appointmentId;
            return this;
        }

        public Builder patientId(int patientId) {
            this.patientId = patientId;
            return this;
        }

        public Builder providerId(int providerId) {
            this.providerId = providerId;
            return this;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public Builder time(String time) {
            this.time = time;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public AppointmentStatus build() {
            AppointmentStatus appointmentStatus = new AppointmentStatus();
            appointmentStatus.appointmentId = this.appointmentId;
            appointmentStatus.patientId = this.patientId;
            appointmentStatus.providerId = this.providerId;
            appointmentStatus.date = this.date;
            appointmentStatus.time = this.time;
            appointmentStatus.status = this.status;
            return appointmentStatus;
        }
    }
}
