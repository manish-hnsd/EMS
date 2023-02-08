package com.hms.services;

import com.hms.dto.AppointmentDTO;

import java.util.List;

public interface AppointmentService {
    void deleteAppointment(Long id);

    AppointmentDTO getAppointment(Long id);

    AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO);

    AppointmentDTO createAppointment(AppointmentDTO appointmentDTO);

    List<AppointmentDTO> getAppointmentsByPatient(Long id);

    List<AppointmentDTO> getAppointmentsByDoctor(Long doctorId);
}
