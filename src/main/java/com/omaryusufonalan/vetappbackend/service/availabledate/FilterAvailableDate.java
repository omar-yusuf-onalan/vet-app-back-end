package com.omaryusufonalan.vetappbackend.service.availabledate;

import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateResponse;
import com.omaryusufonalan.vetappbackend.entity.AvailableDate;

import java.time.LocalDate;
import java.util.List;

public interface FilterAvailableDate {
    List<AvailableDate> filterAvailableDatesByDoctorIdAndAvailableDate(Long doctorId, LocalDate availableDate);
    List<AvailableDateResponse> filterAvailableDateResponsesByDoctorIdAndAvailableDate(
            Long doctorId,
            LocalDate availableDate
    );
}
