package com.omaryusufonalan.vetappbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime appointmentDate;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Animal animal;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "appointment", cascade = CascadeType.REMOVE)
    private Report report;
}
