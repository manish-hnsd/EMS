package com.hms.Controller;

import com.hms.dto.ClinicalDocumentDTO;
import com.hms.services.ClinicalDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clinicalDocument")
public class ClinicalDocumentController {
    @Autowired
    private ClinicalDocumentService clinicalDocumentService;

    @PostMapping
    public ResponseEntity<ClinicalDocumentDTO> createClinicalDocument(@RequestBody ClinicalDocumentDTO clinicalDocumentDTO) {
        ClinicalDocumentDTO createdClinicalDocument = clinicalDocumentService.createClinicalDocument(clinicalDocumentDTO);
        return new ResponseEntity<>(createdClinicalDocument, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicalDocumentDTO> updateClinicalDocument(@PathVariable Long id, @RequestBody ClinicalDocumentDTO clinicalDocumentDTO) {
        ClinicalDocumentDTO updatedClinicalDocument = clinicalDocumentService.updateClinicalDocument(id, clinicalDocumentDTO);
        return new ResponseEntity<>(updatedClinicalDocument, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicalDocumentDTO> getClinicalDocument(@PathVariable Long id) {
        ClinicalDocumentDTO clinicalDocument = clinicalDocumentService.getClinicalDocument(id);
        return new ResponseEntity<>(clinicalDocument, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClinicalDocument(@PathVariable Long id) {
        clinicalDocumentService.deleteClinicalDocument(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
