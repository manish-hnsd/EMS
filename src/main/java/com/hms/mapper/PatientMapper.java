package com.hms.mapper;

import com.hms.dto.PatientDTO;
import com.hms.entity.Patient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientDTO toPatientDTO(Patient patient);
    Patient toPatient(PatientDTO patientDTO);
    List<PatientDTO> toPatientDTOs(List<Patient> patients);
    List<Patient> toPatients(List<PatientDTO> patientDTOs);
}
