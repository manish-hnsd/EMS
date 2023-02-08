package com.hms.Repository;

import com.hms.entity.ElectronicMedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectronicMedicalRecordRepository extends JpaRepository<ElectronicMedicalRecord,Long> {

    ElectronicMedicalRecord findByPatientId(Long id);
}
