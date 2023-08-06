package com.hackathon.userauthenticationservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pactient_Id")
    private int id;
    private String name;
    private String password;
    private String email;
    private String city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Patient(int id, String name, String password, String email, String city) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.city = city;
	}
	public Patient() {}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", city=" + city
				+ "]";
	}
	
}
