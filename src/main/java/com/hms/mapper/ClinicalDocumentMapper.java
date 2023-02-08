package com.hms.mapper;

import com.hms.dto.ClinicalDocumentDTO;
import com.hms.entity.ClinicalDocument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClinicalDocumentMapper {

    ClinicalDocumentMapper INSTANCE = Mappers.getMapper(ClinicalDocumentMapper.class);

    ClinicalDocumentDTO toDTO(ClinicalDocument clinicalDocument);

    ClinicalDocument toEntity(ClinicalDocumentDTO clinicalDocumentDTO);
}
