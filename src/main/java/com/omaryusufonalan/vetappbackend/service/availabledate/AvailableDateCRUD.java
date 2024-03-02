package com.omaryusufonalan.vetappbackend.service.availabledate;

import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateCreateRequest;
import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateResponse;
import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateUpdateRequest;
import com.omaryusufonalan.vetappbackend.entity.AvailableDate;

public interface AvailableDateCRUD {
    AvailableDate getAvailableDateById(Long id);
    AvailableDateResponse getAvailableDateResponseById(Long id);
    AvailableDateResponse createAvailableDate(AvailableDateCreateRequest availableDateCreateRequest);
    AvailableDateResponse updateAvailableDate(AvailableDateUpdateRequest availableDateUpdateRequest);
    void deleteAvailableDateById(Long id);
}
