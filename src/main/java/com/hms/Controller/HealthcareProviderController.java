package com.hms.Controller;

import com.hms.dto.HealthcareProviderDTO;
import com.hms.services.HealthcareProviderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/providers")
public class HealthcareProviderController {
    private final HealthcareProviderService healthcareProviderService;

    public HealthcareProviderController(HealthcareProviderService healthcareProviderService) {
        this.healthcareProviderService = healthcareProviderService;
    }

    @GetMapping
    public List<HealthcareProviderDTO> getAllProviders() {
        return healthcareProviderService.getAllProviders();
    }

    @GetMapping("/{id}")
    public HealthcareProviderDTO getProviderById(@PathVariable Long id) {
        return healthcareProviderService.getProviderById(id);
    }

    @PostMapping
    public HealthcareProviderDTO createProvider(@RequestBody HealthcareProviderDTO healthcareProviderDTO) {
        return healthcareProviderService.createProvider(healthcareProviderDTO);
    }

    @PutMapping("/{id}")
    public HealthcareProviderDTO updateProvider(@PathVariable Long id, @RequestBody HealthcareProviderDTO healthcareProviderDTO) {
        return healthcareProviderService.updateProvider(id, healthcareProviderDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProvider(@PathVariable Long id) {
        healthcareProviderService.deleteProvider(id);
    }
}
