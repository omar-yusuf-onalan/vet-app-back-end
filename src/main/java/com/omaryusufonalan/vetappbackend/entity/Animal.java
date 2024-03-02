package com.omaryusufonalan.vetappbackend.entity;

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
public class Animal {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String species;

    private String breed;

    private String gender;

    private String color;

    private LocalDate dateOfBirth;

    @ManyToOne
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "animal", cascade = CascadeType.REMOVE)
    private List<Vaccine> vaccines;
}
