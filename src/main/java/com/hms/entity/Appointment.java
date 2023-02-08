package com.hms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long doctorId;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private HealthcareProvider healthcareProvider;
    private LocalDateTime appointmentDate;
    private String reason;
    private String Status;
    private boolean isMissed;
}
