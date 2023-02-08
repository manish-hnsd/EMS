package com.hms.services;

import com.hms.dto.MedicationDTO;

import java.util.List;

public interface MedicationService{

    MedicationDTO createMedication(MedicationDTO medicationDTO);

    MedicationDTO updateMedication(Long id, MedicationDTO medicationDTO);

    MedicationDTO getMedication(Long id);

    List<MedicationDTO> getAllMedications();

    void deleteMedication(Long id);
}
