package com.francesco.app.simple_appointment_manager.service.appointment;

import com.francesco.app.simple_appointment_manager.dto.AppointmentDTO;
import com.francesco.app.simple_appointment_manager.dto.AppointmentRequestDTO;
import com.francesco.app.simple_appointment_manager.dto.mapper.AppointmentMapper;
import com.francesco.app.simple_appointment_manager.entity.Appointment;
import com.francesco.app.simple_appointment_manager.entity.User;
import com.francesco.app.simple_appointment_manager.exception.appointment.AppointmentNotFoundException;
import com.francesco.app.simple_appointment_manager.exception.user.UserNotFoundException;
import com.francesco.app.simple_appointment_manager.repository.AppointmentRepository;
import com.francesco.app.simple_appointment_manager.repository.UserRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repo;
    private final UserRepository userRepo;
    private final AppointmentMapper mapper;

    public AppointmentServiceImpl(AppointmentRepository repo, AppointmentMapper mapper, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
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
        User user = userRepo.findById(appointment.getUserId())
                .orElseThrow(() -> new UserNotFoundException(appointment.getUserId()));

        Appointment newAppointment = new Appointment();
        newAppointment.setDateTime(appointment.getDateTime());
        newAppointment.setUser(user);

        return mapper.toAppointmentDTO(repo.save(newAppointment));
    }

    @Override
    public AppointmentDTO updateAppointment(Long id, AppointmentRequestDTO appointment) {
        Appointment checkAppointment = repo.findById(id).orElseThrow(() -> new AppointmentNotFoundException(id));

        checkAppointment.setDateTime(appointment.getDateTime());

        return mapper.toAppointmentDTO(repo.save(checkAppointment));
    }

    @Override
    public void deleteAppointment(Long id) {
        Appointment appointment = repo.findById(id).orElseThrow(() -> new AppointmentNotFoundException(id));

        repo.deleteById(appointment.getId());
    }
}
