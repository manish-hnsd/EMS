package com.hms.Controller;

import com.hms.dto.MedicationDTO;
import com.hms.services.impl.MedicationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medications")
public class MedicationController  {
    private final MedicationServiceImpl medicationService;

    public MedicationController(MedicationServiceImpl medicationService) {
        this.medicationService = medicationService;
    }

    @PostMapping
    public ResponseEntity<MedicationDTO> createMedication(@RequestBody MedicationDTO medicationDTO) {
        MedicationDTO createdMedication = medicationService.createMedication(medicationDTO);
        return new ResponseEntity<>(createdMedication, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicationDTO> updateMedicationManagement(@PathVariable Long id, @RequestBody MedicationDTO medicationDTO) {
        MedicationDTO updatedMedicationManagement = medicationService.updateMedication(id, medicationDTO);
        return new ResponseEntity<>(updatedMedicationManagement, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationDTO> getMedicationManagement(@PathVariable Long id) {
        MedicationDTO medicationManagement = medicationService.getMedication(id);
        return new ResponseEntity<>(medicationManagement, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicationManagement(@PathVariable Long id) {
        medicationService.deleteMedication(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
