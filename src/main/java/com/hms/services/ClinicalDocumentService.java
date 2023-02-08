package com.hms.services;

import com.hms.dto.ClinicalDocumentDTO;

public interface ClinicalDocumentService {

    ClinicalDocumentDTO createClinicalDocument(ClinicalDocumentDTO clinicalDocumentDTO);

    ClinicalDocumentDTO getClinicalDocument(Long id);

    void deleteClinicalDocument(Long id);

    ClinicalDocumentDTO updateClinicalDocument(Long id, ClinicalDocumentDTO clinicalDocumentDTO);
}
