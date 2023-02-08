package com.hms.mapper;

import com.hms.dto.MedicalHistoryDTO;
import com.hms.entity.MedicalHistory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicalHistoryMapper {
    MedicalHistoryDTO toMedicalHistoryDto(MedicalHistory medicalHistory);
    MedicalHistory toMedicalHistory(MedicalHistoryDTO medicalHistoryDto);

    List<MedicalHistoryDTO> toDTOList(List<MedicalHistory> medicalHistory);
}
