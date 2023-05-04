package com.hms.mapper;

import com.hms.dto.AppointmentDTO;
import com.hms.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Mapper
public interface AppointmentMapper {
    //AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    AppointmentDTO toDTO(Appointment appointment);
    Appointment toEntity(AppointmentDTO appointmentDto);
    List<AppointmentDTO> toAppointmentDtoList(List<Appointment> appointments);
}
