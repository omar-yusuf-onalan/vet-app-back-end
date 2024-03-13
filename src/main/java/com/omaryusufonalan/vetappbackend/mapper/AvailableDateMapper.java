package com.omaryusufonalan.vetappbackend.mapper;

import com.omaryusufonalan.vetappbackend.core.MapperTemplate;
import com.omaryusufonalan.vetappbackend.dto.request.AvailableDateRequest;
import com.omaryusufonalan.vetappbackend.dto.response.AvailableDateResponse;
import com.omaryusufonalan.vetappbackend.entity.AvailableDate;
import org.mapstruct.Mapper;

@Mapper
public interface AvailableDateMapper extends MapperTemplate<AvailableDate, AvailableDateRequest, AvailableDateResponse> {
}
