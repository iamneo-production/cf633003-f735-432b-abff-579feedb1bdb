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
public class HealthcareProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provide_Id")
    private int id;
    private String name;
    private String specialization;
    private String email;
    private String password;
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
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public HealthcareProvider(int id, String name, String specialization, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.email = email;
		this.password = password;
	}
	public HealthcareProvider() {}
	@Override
	public String toString() {
		return "HealthcareProvider [id=" + id + ", name=" + name + ", specialization=" + specialization + ", email="
				+ email + ", password=" + password + "]";
	}
}
