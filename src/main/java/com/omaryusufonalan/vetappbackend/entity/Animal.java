package com.omaryusufonalan.vetappbackend.entity;

import com.omaryusufonalan.vetappbackend.core.EntityTemplate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Animal extends EntityTemplate {
    private String name;

    private String species;

    private String breed;

    private String gender;

    private String color;

    private LocalDate dateOfBirth;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "animal", cascade = CascadeType.REMOVE)
    private List<Vaccine> vaccines;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "animal", cascade = CascadeType.REMOVE)
    private List<Appointment> appointments;
}
