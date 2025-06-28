package com.francesco.app.simple_appointment_manager.service.appointment;

import com.francesco.app.simple_appointment_manager.dto.AppointmentDTO;
import com.francesco.app.simple_appointment_manager.dto.AppointmentRequestDTO;
import com.francesco.app.simple_appointment_manager.dto.mapper.AppointmentMapper;
import com.francesco.app.simple_appointment_manager.entity.Appointment;
import com.francesco.app.simple_appointment_manager.exception.appointment.AppointmentNotFoundException;
import com.francesco.app.simple_appointment_manager.repository.AppointmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repo;
    private final AppointmentMapper mapper;

    public AppointmentServiceImpl(AppointmentRepository repo, AppointmentMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<AppointmentDTO> findAllAppointment() {
        return mapper.toAppointmentDTOList(repo.findAll());
    }

    @Override
    public AppointmentDTO findAppointmentById(Long id) {
        return mapper.toAppointmentDTO(repo.findById(id).orElseThrow(() -> new AppointmentNotFoundException(id)));
    }

    @Override
    public AppointmentDTO createAppointment(AppointmentRequestDTO appointment) {
        return mapper.toAppointmentDTO(repo.save(mapper.toCreateAppointmentEntity(appointment)));
    }

    @Override
    public AppointmentDTO updateAppointment(Long id, AppointmentRequestDTO appointment)
    {
        Appointment checkAppointment = repo.findById(id).orElseThrow(() -> new AppointmentNotFoundException(id));

        return mapper.toAppointmentDTO(repo.save(checkAppointment));
    }

    @Override
    public void deleteAppointment(Long id) {
        Appointment appointment = repo.findById(id).orElseThrow(() -> new AppointmentNotFoundException(id));

        repo.deleteById(id);
    }
}
