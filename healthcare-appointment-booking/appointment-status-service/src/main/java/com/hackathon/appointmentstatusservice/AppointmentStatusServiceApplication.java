package com.hackathon.appointmentstatusservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppointmentStatusServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentStatusServiceApplication.class, args);
	}

}