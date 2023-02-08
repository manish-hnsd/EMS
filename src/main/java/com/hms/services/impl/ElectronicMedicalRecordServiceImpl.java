package com.hms.services.impl;

import com.hms.Repository.ElectronicMedicalRecordRepository;
import com.hms.dto.ElectronicMedicalRecordDTO;
import com.hms.entity.Appointment;
import com.hms.entity.ElectronicMedicalRecord;
import com.hms.exception.ResourceNotFoundException;
import com.hms.mapper.ElectronicMedicalRecordMapper;
import com.hms.services.ElectronicMedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ElectronicMedicalRecordServiceImpl implements ElectronicMedicalRecordService {
    @Autowired
    private ElectronicMedicalRecordRepository electronicMedicalRecordRepository;

    @Autowired
    private ElectronicMedicalRecordMapper electronicMedicalRecordMapper;
    @Override
    public ElectronicMedicalRecordDTO getElectronicMedicalRecord(Long id) {
        ElectronicMedicalRecord electronicMedicalRecord = electronicMedicalRecordRepository.findByPatientId(id);
        return electronicMedicalRecordMapper.toDto(electronicMedicalRecord);
    }

    @Override
    public ElectronicMedicalRecordDTO createElectronicMedicalRecord(ElectronicMedicalRecordDTO electronicMedicalRecordDTO) {
        ElectronicMedicalRecord electronicMedicalRecord = electronicMedicalRecordMapper.toEntity(electronicMedicalRecordDTO);
        ElectronicMedicalRecord savedElectronicMedicalRecord = electronicMedicalRecordRepository.save(electronicMedicalRecord);
        return electronicMedicalRecordMapper.toDto(savedElectronicMedicalRecord);
    }

    @Override
    public ElectronicMedicalRecordDTO updateElectronicMedicalRecord(Long id, ElectronicMedicalRecordDTO electronicMedicalRecordDTO)  throws ResourceNotFoundException{
        ElectronicMedicalRecord electronicMedicalRecord = electronicMedicalRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Electronic Medical Record not found for this id :: " + id));

        electronicMedicalRecord.setId(electronicMedicalRecordDTO.getId());
        electronicMedicalRecord.setPatient(electronicMedicalRecord.getPatient());
        electronicMedicalRecord.setLabResults(electronicMedicalRecordDTO.getLabResults());
        electronicMedicalRecord.setImagingStudies(electronicMedicalRecordDTO.getImagingStudies());
        electronicMedicalRecord.setOtherInformation(electronicMedicalRecordDTO.getOtherInformation());

        final ElectronicMedicalRecord updatedElectronicMedicalRecord = electronicMedicalRecordRepository.save(electronicMedicalRecord);
        return electronicMedicalRecordMapper.toDto(updatedElectronicMedicalRecord);
    }

    @Override
    public void deleteElectronicMedicalRecord(Long id) {
        ElectronicMedicalRecord electronicMedicalRecord = electronicMedicalRecordRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Appointment not found with id " + id));
        electronicMedicalRecordRepository.delete(electronicMedicalRecord);
    }
}
