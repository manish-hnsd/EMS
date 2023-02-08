package com.hms.services;

import com.hms.dto.MedicalHistoryDTO;

import java.util.List;

public interface MedicalHistoryService {
    MedicalHistoryDTO createMedicalHistory(MedicalHistoryDTO medicalHistoryDTO);

    MedicalHistoryDTO updateMedicalHistory(Long id, MedicalHistoryDTO medicalHistoryDTO);

    MedicalHistoryDTO getMedicalHistory(Long id);

    void deleteMedicalHistory(Long id);

    MedicalHistoryDTO getMedicalHistoryByPatientId(Long patientId);

    List<MedicalHistoryDTO> getAllMedicalHistory();
}
