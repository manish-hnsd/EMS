package com.hms.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AppointmentDTO {
    private Long id;
    private Long doctorId;
    private PatientDTO patient;
    private HealthcareProviderDTO healthcareProvider;
    private LocalDateTime appointmentDate;
    private String reason;
    private String Status;
    private Boolean isMissed;
}
