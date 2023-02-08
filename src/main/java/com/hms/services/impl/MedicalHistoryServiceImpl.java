package com.hms.services.impl;

import com.hms.Repository.MedicalHistoryRepository;
import com.hms.dto.MedicalHistoryDTO;
import com.hms.entity.MedicalHistory;
import com.hms.exception.ResourceNotFoundException;
import com.hms.mapper.MedicalHistoryMapper;
import com.hms.services.MedicalHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {
    private final MedicalHistoryRepository medicalHistoryRepository;
    private final MedicalHistoryMapper medicalHistoryMapper;

    public MedicalHistoryServiceImpl(MedicalHistoryRepository medicalHistoryRepository, MedicalHistoryMapper medicalHistoryMapper) {
        this.medicalHistoryRepository = medicalHistoryRepository;
        this.medicalHistoryMapper = medicalHistoryMapper;
    }
    @Override
    public MedicalHistoryDTO getMedicalHistoryByPatientId(Long patientId) {
        MedicalHistory medicalHistory = medicalHistoryRepository.findByPatientId(patientId);
        return medicalHistoryMapper.toMedicalHistoryDto(medicalHistory);
    }

    @Override
    public MedicalHistoryDTO createMedicalHistory(MedicalHistoryDTO medicalHistoryDTO) {
        MedicalHistory medicalHistory = medicalHistoryMapper.toMedicalHistory(medicalHistoryDTO);
        medicalHistory = medicalHistoryRepository.save(medicalHistory);
        return medicalHistoryMapper.toMedicalHistoryDto(medicalHistory);
    }

    @Override
    public MedicalHistoryDTO updateMedicalHistory(Long id, MedicalHistoryDTO medicalHistoryDTO) throws ResourceNotFoundException{
        MedicalHistory medicalHistory = medicalHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medical history not found with id: " + id));
        medicalHistory.setPatient(medicalHistoryMapper.toMedicalHistory(medicalHistoryDTO).getPatient());
        medicalHistory.setPastIllness(medicalHistoryMapper.toMedicalHistory(medicalHistoryDTO).getPastIllness());
        medicalHistory.setSurgeries(medicalHistoryMapper.toMedicalHistory(medicalHistoryDTO).getSurgeries());
        medicalHistory.setAllergies(medicalHistoryMapper.toMedicalHistory(medicalHistoryDTO).getAllergies());
        medicalHistory.setMedications(medicalHistoryMapper.toMedicalHistory(medicalHistoryDTO).getMedications());
        medicalHistory = medicalHistoryRepository.save(medicalHistory);
        return medicalHistoryMapper.toMedicalHistoryDto(medicalHistory);
    }

    @Override
    public MedicalHistoryDTO getMedicalHistory(Long id) throws ResourceNotFoundException {
        MedicalHistory medicalHistory = medicalHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medical history not found with id: " + id));
        return medicalHistoryMapper.toMedicalHistoryDto(medicalHistory);
    }

    @Override
    public void deleteMedicalHistory(Long id) throws ResourceNotFoundException{
        MedicalHistory medicalHistory = medicalHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medical history not found with id: " + id));
        medicalHistoryRepository.delete(medicalHistory);
    }
    @Override
    public List<MedicalHistoryDTO> getAllMedicalHistory() {
        List<MedicalHistory> medicalHistory = medicalHistoryRepository.findAll();
        return medicalHistoryMapper.toDTOList(medicalHistory);
    }
}
