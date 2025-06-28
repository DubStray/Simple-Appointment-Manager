package com.francesco.app.simple_appointment_manager.dto.mapper;

import com.francesco.app.simple_appointment_manager.dto.AppointmentDTO;
import com.francesco.app.simple_appointment_manager.dto.AppointmentRequestDTO;
import com.francesco.app.simple_appointment_manager.entity.Appointment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    AppointmentRequestDTO toCreateAppointmentDTO(Appointment appointment);

    AppointmentDTO toAppointmentDTO(Appointment appointment);

    Appointment toCreateAppointmentEntity(AppointmentRequestDTO appointment);

    List<AppointmentDTO> toAppointmentDTOList(List<Appointment> appointments);
}
