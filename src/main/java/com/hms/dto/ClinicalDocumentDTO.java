package com.hms.dto;

import lombok.Data;

@Data
public class ClinicalDocumentDTO {
    private Long id;
    private String documentType;
    private PatientDTO patient;
    private HealthcareProviderDTO healthcareProvider;
    private String notes;
    private String observations;
    private String treatmentPlan;
    private String createdBy;
}
