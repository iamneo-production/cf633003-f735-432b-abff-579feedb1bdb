package com.hackathon.communicationservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Communication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int communicationId;
    private int patientId;
    private int healthcareProviderId;
    private int appointmentId;
}
