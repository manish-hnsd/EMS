package com.hms.Controller;

import com.hms.dto.MedicalHistoryDTO;
import com.hms.services.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicalHistories")
public class MedicalHistoryController {
    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @PostMapping("/create")
    public ResponseEntity<MedicalHistoryDTO> createMedicalHistory(@RequestBody MedicalHistoryDTO medicalHistoryDTO) {
        MedicalHistoryDTO createdMedicalHistory = medicalHistoryService.createMedicalHistory(medicalHistoryDTO);
        return new ResponseEntity<>(createdMedicalHistory, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MedicalHistoryDTO> updateMedicalHistory(@PathVariable Long id, @RequestBody MedicalHistoryDTO medicalHistoryDTO) {
        MedicalHistoryDTO updatedMedicalHistory = medicalHistoryService.updateMedicalHistory(id, medicalHistoryDTO);
        return new ResponseEntity<>(updatedMedicalHistory, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MedicalHistoryDTO> getMedicalHistory(@PathVariable Long id) {
        MedicalHistoryDTO medicalHistory = medicalHistoryService.getMedicalHistory(id);
        return new ResponseEntity<>(medicalHistory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMedicalHistory(@PathVariable Long id) {
        medicalHistoryService.deleteMedicalHistory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<MedicalHistoryDTO> getMedicalHistoryByPatientId(@PathVariable Long id) {
        MedicalHistoryDTO medicalHistoryDTO = medicalHistoryService.getMedicalHistoryByPatientId(id);
        return new ResponseEntity<>(medicalHistoryDTO, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MedicalHistoryDTO>> getAllMedicalHistory() {
        List<MedicalHistoryDTO> medicalHistory = medicalHistoryService.getAllMedicalHistory();
        return ResponseEntity.ok(medicalHistory);
    }
}
