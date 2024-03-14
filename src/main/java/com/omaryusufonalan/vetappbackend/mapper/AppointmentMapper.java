package com.omaryusufonalan.vetappbackend.mapper;

import com.omaryusufonalan.vetappbackend.core.MapperTemplate;
import com.omaryusufonalan.vetappbackend.dto.only.OnlyAnimalDTO;
import com.omaryusufonalan.vetappbackend.dto.only.OnlyCustomerDTO;
import com.omaryusufonalan.vetappbackend.dto.only.OnlyDoctorDTO;
import com.omaryusufonalan.vetappbackend.dto.request.AppointmentRequest;
import com.omaryusufonalan.vetappbackend.dto.response.AppointmentResponse;
import com.omaryusufonalan.vetappbackend.entity.Animal;
import com.omaryusufonalan.vetappbackend.entity.Appointment;
import com.omaryusufonalan.vetappbackend.entity.Customer;
import com.omaryusufonalan.vetappbackend.entity.Doctor;
import org.mapstruct.Mapper;

@Mapper
public interface AppointmentMapper extends MapperTemplate<Appointment, AppointmentRequest, AppointmentResponse> {
    Doctor dtoToEntity(OnlyDoctorDTO onlyDoctorDTO);
    Animal dtoToEntity(OnlyAnimalDTO onlyAnimalDTO);
}
