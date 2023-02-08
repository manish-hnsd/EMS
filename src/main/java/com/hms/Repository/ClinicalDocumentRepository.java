package com.hms.Repository;

import com.hms.entity.ClinicalDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicalDocumentRepository extends JpaRepository<ClinicalDocument, Long> {
}
