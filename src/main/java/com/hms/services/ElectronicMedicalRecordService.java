package com.hms.services;

import com.hms.dto.ElectronicMedicalRecordDTO;

public interface ElectronicMedicalRecordService {
    ElectronicMedicalRecordDTO getElectronicMedicalRecord(Long patientId);
    ElectronicMedicalRecordDTO createElectronicMedicalRecord(ElectronicMedicalRecordDTO electronicMedicalRecordDTO);
    ElectronicMedicalRecordDTO updateElectronicMedicalRecord(Long patientId, ElectronicMedicalRecordDTO electronicMedicalRecordDTO);

    void deleteElectronicMedicalRecord(Long patientId);
}
