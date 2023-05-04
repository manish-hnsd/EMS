package com.hms.services.impl;

import com.hms.Repository.ClinicalDocumentRepository;
import com.hms.dto.ClinicalDocumentDTO;
import com.hms.entity.ClinicalDocument;
import com.hms.exception.ResourceNotFoundException;
import com.hms.mapper.ClinicalDocumentMapper;
import com.hms.services.ClinicalDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicalDocumentServiceImpl implements ClinicalDocumentService {
    private ClinicalDocumentRepository clinicalDocumentRepository;
    private ClinicalDocumentMapper clinicalDocumentMapper;

    public ClinicalDocumentServiceImpl(ClinicalDocumentRepository clinicalDocumentRepository, ClinicalDocumentMapper clinicalDocumentMapper){
        this.clinicalDocumentMapper=clinicalDocumentMapper;
        this.clinicalDocumentRepository=clinicalDocumentRepository;
    }

    @Override
    public ClinicalDocumentDTO createClinicalDocument(ClinicalDocumentDTO clinicalDocumentDTO) {
        ClinicalDocument clinicalDocument = clinicalDocumentMapper.toEntity(clinicalDocumentDTO);
        clinicalDocument = clinicalDocumentRepository.save(clinicalDocument);
        return clinicalDocumentMapper.toDTO(clinicalDocument);
    }
    @Override
    public ClinicalDocumentDTO updateClinicalDocument(Long id, ClinicalDocumentDTO clinicalDocumentDTO) {
        ClinicalDocument clinicalDocument = clinicalDocumentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Clinical Documentation not found with id " + id));
        clinicalDocument.setId(clinicalDocumentDTO.getId());
        clinicalDocument.setDocumentType(clinicalDocumentDTO.getDocumentType());
        clinicalDocument.setNotes(clinicalDocumentDTO.getNotes());
        clinicalDocument.setObservations(clinicalDocumentDTO.getObservations());
        clinicalDocument.setTreatmentPlan(clinicalDocumentDTO.getTreatmentPlan());
        clinicalDocument.setCreatedBy(clinicalDocumentDTO.getCreatedBy());
        clinicalDocument = clinicalDocumentRepository.save(clinicalDocument);
        return clinicalDocumentMapper.toDTO(clinicalDocument);
    }
    @Override
    public ClinicalDocumentDTO getClinicalDocument(Long id) {
        ClinicalDocument clinicalDocument = clinicalDocumentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Clinical Documentation not found with id " + id));
        return clinicalDocumentMapper.toDTO(clinicalDocument);
    }
    @Override
    public void deleteClinicalDocument(Long id) {
        ClinicalDocument clinicalDocument = clinicalDocumentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Clinical Documentation not found with id " + id));
        clinicalDocumentRepository.delete(clinicalDocument);
    }
}