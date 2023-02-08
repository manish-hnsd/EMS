package com.hms.dto;

import lombok.Data;

import java.util.List;
@Data
public class MedicalHistoryDTO {
    private Long id;
    private PatientDTO patient;
    private List<String> pastIllness;
    private List<String> surgeries;
    private List<String> allergies;
    private List<String> medications;
}
