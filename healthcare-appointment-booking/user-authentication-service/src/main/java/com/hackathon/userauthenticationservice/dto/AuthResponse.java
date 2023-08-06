package com.hackathon.userauthenticationservice.dto;

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
public class AuthResponse {
    String username;
	String jwtAuthToken;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJwtAuthToken() {
		return jwtAuthToken;
	}
	public void setJwtAuthToken(String jwtAuthToken) {
		this.jwtAuthToken = jwtAuthToken;
	}
	public AuthResponse(String username, String jwtAuthToken) {
		super();
		this.username = username;
		this.jwtAuthToken = jwtAuthToken;
	}
	public AuthResponse() {}
	@Override
	public String toString() {
		return "AuthResponse [username=" + username + ", jwtAuthToken=" + jwtAuthToken + "]";
	}
	
}
