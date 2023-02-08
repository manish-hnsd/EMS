package com.hms.services.impl;

import com.hms.Repository.HealthcareProviderRepository;
import com.hms.dto.HealthcareProviderDTO;
import com.hms.entity.HealthcareProvider;
import com.hms.exception.ProviderNotFoundException;
import com.hms.mapper.HealthcareProviderMapper;
import com.hms.services.HealthcareProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class HealthcareProviderServiceImpl implements HealthcareProviderService {
    private HealthcareProviderRepository healthcareProviderRepository;
    private HealthcareProviderMapper providerMapper;

    @Autowired
    public HealthcareProviderServiceImpl(HealthcareProviderRepository healthcareProviderRepository, HealthcareProviderMapper providerMapper) {
        this.healthcareProviderRepository = healthcareProviderRepository;
        this.providerMapper = providerMapper;
    }

    @Override
    public List<HealthcareProviderDTO> getAllProviders() {
        List<HealthcareProvider> providers = healthcareProviderRepository.findAll();
        return providers.stream().map(providerMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public HealthcareProviderDTO getProviderById(Long id) {
        HealthcareProvider provider = healthcareProviderRepository.findById(id).orElseThrow(() ->
                new ProviderNotFoundException("Provider with id " + id + " not found"));
        return providerMapper.toDTO(provider);
    }

    @Override
    public HealthcareProviderDTO createProvider(HealthcareProviderDTO healthcareProviderDTO) {
        HealthcareProvider provider = providerMapper.fromDTO(healthcareProviderDTO);
        provider = healthcareProviderRepository.save(provider);
        return providerMapper.toDTO(provider);
    }

    @Override
    public HealthcareProviderDTO updateProvider(Long id, HealthcareProviderDTO healthcareProviderDTO) {
        HealthcareProvider provider = healthcareProviderRepository.findById(id).orElseThrow(() ->
                new ProviderNotFoundException("Provider with id " + id + " not found"));
        provider.setFirstName(healthcareProviderDTO.getFirstName());
        provider.setLastName(healthcareProviderDTO.getLastName());
        provider.setSpecialty(healthcareProviderDTO.getSpecialty());
        provider.setPhoneNumber(healthcareProviderDTO.getPhoneNumber());
        provider.setEmail(healthcareProviderDTO.getEmail());
        provider = healthcareProviderRepository.save(provider);
        return providerMapper.toDTO(provider);
    }

    @Override
    public void deleteProvider(Long id) {
        healthcareProviderRepository.deleteById(id);
    }
}
