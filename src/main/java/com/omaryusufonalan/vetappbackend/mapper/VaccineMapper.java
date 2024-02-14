package com.omaryusufonalan.vetappbackend.mapper;

import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineRequest;
import com.omaryusufonalan.vetappbackend.dto.vaccine.VaccineResponse;
import com.omaryusufonalan.vetappbackend.entity.Vaccine;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Set;

@Mapper
public interface VaccineMapper {
    Vaccine asVaccine(VaccineRequest vaccineRequest);

    VaccineResponse asVaccineResponse(Vaccine vaccine);

    Set<VaccineResponse> asVaccineResponses(Set<Vaccine> vaccine);

    void update(@MappingTarget Vaccine vaccine, VaccineRequest vaccineRequest);
}
