package com.hms.services.impl;

import com.hms.Repository.MedicationRepository;
import com.hms.dto.MedicationDTO;
import com.hms.entity.Medication;
import com.hms.exception.ResourceNotFoundException;
import com.hms.mapper.MedicationMapper;
import com.hms.services.MedicationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicationServiceImpl implements MedicationService {
    private final MedicationRepository medicationRepository;
    private final MedicationMapper medicationMapper;

    public MedicationServiceImpl(MedicationRepository medicationRepository, MedicationMapper medicationMapper) {
        this.medicationRepository = medicationRepository;
        this.medicationMapper = medicationMapper;
    }
    @Override
    public MedicationDTO createMedication(MedicationDTO medicationDTO) {
        Medication medication = medicationMapper.toEntity(medicationDTO);
        medication = medicationRepository.save(medication);
        return medicationMapper.toDTO(medication);
    }
    @Override
    public MedicationDTO updateMedication(Long id, MedicationDTO medicationDTO) {
        Medication medication = medicationRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Medication not found with id " + id));
        medication.setId(medicationDTO.getId());
        medication.setName(medicationDTO.getName());
        medication.setDosage(medicationDTO.getDosage());
        medication.setFrequency(medicationDTO.getFrequency());
        medication.setStartDate(medicationDTO.getStartDate());
        medication.setEndDate(medicationDTO.getEndDate());
        medication.setPrescribedBy(medicationDTO.getPrescribedBy());
        medication = medicationRepository.save(medication);
        return medicationMapper.toDTO(medication);
    }
    @Override
    public MedicationDTO getMedication(Long id) {
        Medication medication = medicationRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Medication not found with id " + id));
        return medicationMapper.toDTO(medication);
    }

    @Override
    public List<MedicationDTO> getAllMedications() {
        return medicationRepository.findAll().stream().map(medicationMapper::toDTO).collect(Collectors.toList());
    }
    @Override
    public void deleteMedication(Long id) {
        Medication medication = medicationRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Medication Management not found with id " + id));
        medicationRepository.delete(medication);
    }
}
