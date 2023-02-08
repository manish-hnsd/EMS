package com.hms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clinical_document")
public class ClinicalDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String documentType;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private HealthcareProvider healthcareProvider;
    private String notes;
    private String observations;
    private String treatmentPlan;
    private String createdBy;
}
