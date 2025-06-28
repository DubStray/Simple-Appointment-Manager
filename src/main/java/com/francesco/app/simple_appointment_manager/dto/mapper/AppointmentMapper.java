package com.francesco.app.simple_appointment_manager.dto.mapper;

import com.francesco.app.simple_appointment_manager.dto.AppointmentDTO;
import com.francesco.app.simple_appointment_manager.dto.AppointmentRequestDTO;
import com.francesco.app.simple_appointment_manager.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { UserMapper.class })
public interface AppointmentMapper {

    @Mapping(source = "user", target = "userInfo")
    AppointmentDTO toAppointmentDTO(Appointment appointment);

    Appointment toCreateAppointmentEntity(AppointmentRequestDTO appointment);

    List<AppointmentDTO> toAppointmentDTOList(List<Appointment> appointments);
}
