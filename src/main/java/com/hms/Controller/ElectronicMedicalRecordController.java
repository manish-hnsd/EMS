package com.hms.Controller;

import com.hms.dto.ElectronicMedicalRecordDTO;
import com.hms.services.ElectronicMedicalRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emr")
public class ElectronicMedicalRecordController {
    private final ElectronicMedicalRecordService electronicMedicalRecordService;

    public ElectronicMedicalRecordController(ElectronicMedicalRecordService electronicMedicalRecordService) {
        this.electronicMedicalRecordService = electronicMedicalRecordService;
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<ElectronicMedicalRecordDTO> getElectronicMedicalRecord(@PathVariable Long patientId) {
        ElectronicMedicalRecordDTO electronicMedicalRecordDTO = electronicMedicalRecordService.getElectronicMedicalRecord(patientId);
        return ResponseEntity.ok(electronicMedicalRecordDTO);
    }

    @PostMapping
    public ResponseEntity<ElectronicMedicalRecordDTO> createElectronicMedicalRecord(@RequestBody ElectronicMedicalRecordDTO electronicMedicalRecordDTO) {
        ElectronicMedicalRecordDTO createdElectronicMedicalRecord = electronicMedicalRecordService.createElectronicMedicalRecord(electronicMedicalRecordDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdElectronicMedicalRecord);
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<ElectronicMedicalRecordDTO> updateElectronicMedicalRecord(@PathVariable Long patientId, @RequestBody ElectronicMedicalRecordDTO electronicMedicalRecordDTO) {
        ElectronicMedicalRecordDTO updatedElectronicMedicalRecord = electronicMedicalRecordService.updateElectronicMedicalRecord(patientId, electronicMedicalRecordDTO);
        return ResponseEntity.ok(updatedElectronicMedicalRecord);
    }
    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deleteElectronicMedicalRecord(@PathVariable Long patientId) {
        electronicMedicalRecordService.deleteElectronicMedicalRecord(patientId);
        return ResponseEntity.noContent().build();
    }
    // add other methods as per requirement
}
