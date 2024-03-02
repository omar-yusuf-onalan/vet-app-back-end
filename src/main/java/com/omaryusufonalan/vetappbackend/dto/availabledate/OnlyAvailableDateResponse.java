package com.omaryusufonalan.vetappbackend.dto.availabledate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OnlyAvailableDateResponse {
    private Long id;

    private LocalDate availableDate;
}
