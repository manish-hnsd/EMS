package com.hms.dto;

import lombok.Data;

@Data
public class HealthcareProviderDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String specialty;
    private String phoneNumber;
    private String email;
    //getters and setters
}
