package com.hms.services;

import com.hms.dto.PatientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    PatientDTO getPatientById(Long id);
    List<PatientDTO> getAllPatients();
    PatientDTO createPatient(PatientDTO patientDto);
    PatientDTO updatePatient(Long patientId, PatientDTO patientDto);
    void deletePatient(Long patientId);
}

