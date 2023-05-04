package com.hms.services.impl;

import com.hms.Repository.AppointmentRepository;
import com.hms.dto.AppointmentDTO;
import com.hms.entity.Appointment;
import com.hms.exception.ResourceNotFoundException;
import com.hms.mapper.AppointmentMapper;
import com.hms.services.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;
    private AppointmentMapper appointmentMapper;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper){
        this.appointmentMapper=appointmentMapper;
        this.appointmentRepository=appointmentRepository;
    }

    public AppointmentServiceImpl() {
    }

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = appointmentMapper.toEntity(appointmentDTO);
        appointment = appointmentRepository.save(appointment);
        return appointmentMapper.toDTO(appointment);
    }
    @Override
    public AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Appointment not found with id " + id));
        appointment.setId(appointmentDTO.getId());
        appointment.setDoctorId(appointmentDTO.getDoctorId());
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setReason(appointmentDTO.getReason());
        appointment.setStatus(appointmentDTO.getStatus());
        appointment = appointmentRepository.save(appointment);
        return appointmentMapper.toDTO(appointment);
    }
    @Override
    public AppointmentDTO getAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Appointment not found with id " + id));
        return appointmentMapper.toDTO(appointment);
    }
    @Override
    public void deleteAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Appointment not found with id " + id));
        appointmentRepository.delete(appointment);
    }
    @Override
    public List<AppointmentDTO> getAppointmentsByPatient(Long id) {
        List<Appointment> appointments = appointmentRepository.findByPatientId(id);
        return appointmentMapper.toAppointmentDtoList(appointments);
    }
    @Override
    public List<AppointmentDTO> getAppointmentsByDoctor(Long doctorId) {
        List<Appointment> appointments = appointmentRepository.findByDoctorId(doctorId);
        return appointmentMapper.toAppointmentDtoList(appointments);
    }
}
