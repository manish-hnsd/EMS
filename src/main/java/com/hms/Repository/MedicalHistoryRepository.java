package com.hms.Repository;

import com.hms.entity.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
    MedicalHistory findByPatientId(Long patientId);
}

