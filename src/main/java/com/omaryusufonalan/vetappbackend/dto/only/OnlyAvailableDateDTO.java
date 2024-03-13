package com.omaryusufonalan.vetappbackend.dto.only;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OnlyAvailableDateDTO {
    private Long id;

    private LocalDate availableDate;
}
