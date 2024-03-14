package com.omaryusufonalan.vetappbackend.mapper;

import com.omaryusufonalan.vetappbackend.core.MapperTemplate;
import com.omaryusufonalan.vetappbackend.dto.only.OnlyAnimalDTO;
import com.omaryusufonalan.vetappbackend.dto.only.OnlyReportDTO;
import com.omaryusufonalan.vetappbackend.dto.request.VaccineRequest;
import com.omaryusufonalan.vetappbackend.dto.response.VaccineResponse;
import com.omaryusufonalan.vetappbackend.entity.Animal;
import com.omaryusufonalan.vetappbackend.entity.Report;
import com.omaryusufonalan.vetappbackend.entity.Vaccine;
import org.mapstruct.Mapper;

@Mapper
public interface VaccineMapper extends MapperTemplate<Vaccine, VaccineRequest, VaccineResponse> {
    Animal dtoToEntity(OnlyAnimalDTO onlyAnimalDTO);
    Report dtoToEntity(OnlyReportDTO onlyReportDTO);
}
