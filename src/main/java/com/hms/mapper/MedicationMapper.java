package com.hms.mapper;

import com.hms.dto.MedicationDTO;
import com.hms.entity.Medication;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicationMapper {
    MedicationMapper INSTANCE = Mappers.getMapper(MedicationMapper.class);

    MedicationDTO toDTO(Medication medication);

    Medication toEntity(MedicationDTO medicationDTO);
}
