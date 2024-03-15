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
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "animal", cascade = CascadeType.REMOVE)
    private List<Vaccine> vaccines;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "animal", cascade = CascadeType.REMOVE)
    private List<Appointment> appointments;
}
