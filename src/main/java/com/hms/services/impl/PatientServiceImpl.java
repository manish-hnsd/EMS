package com.hms.services.impl;

import com.hms.Repository.PatientRepository;
import com.hms.dto.PatientDTO;
import com.hms.entity.Patient;
import com.hms.exception.ResourceNotFoundException;
import com.hms.mapper.PatientMapper;
import com.hms.services.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientServiceImpl(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        return patientMapper.toPatientDTO(patientRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Patient not found with id " + id)));
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll().stream().map(patientMapper::toPatientDTO).collect(Collectors.toList());
    }

    @Override
    public PatientDTO createPatient(PatientDTO patientDto) {
        Patient patient = patientMapper.toPatient(patientDto);
        return patientMapper.toPatientDTO(patientRepository.save(patient));
    }

    @Override
    public PatientDTO updatePatient(Long id, PatientDTO patientDto) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient id not found"));
        patient.setFirstName(patientDto.getFirstName());
        patient.setLastName(patientDto.getLastName());
        patient.setAddress(patientDto.getAddress());
        patient.setPhoneNumber(patientDto.getPhoneNumber());
        patient.setInsuranceProvider(patientDto.getInsuranceProvider());
        patient = patientRepository.save(patient);
        return patientMapper.toPatientDTO(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}

