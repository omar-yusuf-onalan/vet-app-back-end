package com.omaryusufonalan.vetappbackend.mapper;

import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateRequest;
import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateResponse;
import com.omaryusufonalan.vetappbackend.entity.AvailableDate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Set;

@Mapper
public interface AvailableDateMapper {
    AvailableDate asAvailableDate(AvailableDateRequest availableDateRequest);

    AvailableDateResponse asAvailableDateResponse(AvailableDate availableDate);

    Set<AvailableDateResponse> asAvailableDateResponses(Set<AvailableDate> availableDate);

    void update(@MappingTarget AvailableDate availableDate, AvailableDateRequest availableDateRequest);
}
