package com.hms.dto;

import com.hms.validation.AgeConstraint;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class PatientDTO {
    private Long id;
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;
    private String address;

    @AgeConstraint
    private Integer age;

    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;
    private String insuranceProvider;
}
