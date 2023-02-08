package com.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElectronicMedicalRecordDTO {
    private Long id;
    private PatientDTO patient;
    private List<String> labResults;
    private List<String> imagingStudies;
    private List<String> otherInformation;
}
