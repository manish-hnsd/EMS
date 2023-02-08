package com.hms.services;

import com.hms.dto.HealthcareProviderDTO;

import java.util.List;

public interface HealthcareProviderService {
    List<HealthcareProviderDTO> getAllProviders();
    HealthcareProviderDTO getProviderById(Long id);
    HealthcareProviderDTO createProvider(HealthcareProviderDTO healthcareProviderDTO);
    HealthcareProviderDTO updateProvider(Long id, HealthcareProviderDTO healthcareProviderDTO);
    void deleteProvider(Long id);
}
