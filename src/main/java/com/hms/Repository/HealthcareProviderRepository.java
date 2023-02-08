package com.hms.Repository;

import com.hms.entity.HealthcareProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthcareProviderRepository extends JpaRepository<HealthcareProvider, Long> {
}
