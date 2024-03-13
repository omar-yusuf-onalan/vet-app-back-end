package com.omaryusufonalan.vetappbackend.service.filter;

import com.omaryusufonalan.vetappbackend.dto.response.AvailableDateResponse;

import java.time.LocalDate;
import java.util.List;

public interface FilterAvailableDate {
    List<AvailableDateResponse> filterAvailableDateResponsesByDoctorIdAndAvailableDate(
            Long doctorId,
            LocalDate availableDate
    );
}
