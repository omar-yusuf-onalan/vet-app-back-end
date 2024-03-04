package com.omaryusufonalan.vetappbackend.service.availabledate;

import com.omaryusufonalan.vetappbackend.dto.availabledate.AvailableDateResponse;
import com.omaryusufonalan.vetappbackend.entity.AvailableDate;

import java.util.List;

public interface AvailableDatePage {
    List<AvailableDate> getAvailableDatePage(int page, int pageSize);
    List<AvailableDateResponse> getAvailableDateResponsePage(int page, int pageSize);
}
