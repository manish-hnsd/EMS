package com.hms.mapper;

import com.hms.dto.HealthcareProviderDTO;
import com.hms.entity.HealthcareProvider;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface HealthcareProviderMapper {

    HealthcareProviderMapper INSTANCE = Mappers.getMapper(HealthcareProviderMapper.class);

    HealthcareProvider fromDTO(HealthcareProviderDTO healthcareProviderDTO);

    HealthcareProviderDTO toDTO(HealthcareProvider healthcareProvider);

    @Mapping(target = "id", ignore = true)
    HealthcareProvider toEntity(HealthcareProviderDTO healthcareProviderDTO);
}
