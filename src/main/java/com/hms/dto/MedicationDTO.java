package com.hms.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MedicationDTO {
    private Long id;
    private String name;
    private String dosage;
    private String frequency;
    private LocalDate startDate;
    private LocalDate endDate;
    private String prescribedBy;
}
