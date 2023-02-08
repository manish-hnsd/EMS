package com.hms.mapper;

import com.hms.dto.ElectronicMedicalRecordDTO;
import com.hms.entity.ElectronicMedicalRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ElectronicMedicalRecordMapper {
    //ElectronicMedicalRecordMapper INSTANCE = Mappers.getMapper(ElectronicMedicalRecordMapper.class);


    ElectronicMedicalRecordDTO toDto(ElectronicMedicalRecord electronicMedicalRecord);


    ElectronicMedicalRecord toEntity(ElectronicMedicalRecordDTO electronicMedicalRecordDTO);

    //ElectronicMedicalRecord updateElectronicMedicalRecordFromDTO(ElectronicMedicalRecord electronicMedicalRecord, ElectronicMedicalRecordDTO electronicMedicalRecordDTO);
}
