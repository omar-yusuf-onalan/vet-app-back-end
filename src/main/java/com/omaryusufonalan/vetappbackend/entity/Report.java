package com.omaryusufonalan.vetappbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Report {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String diagnosis;

    private double price;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Appointment appointment;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "report", cascade = CascadeType.REMOVE)
    private Set<Vaccine> vaccines;
}
