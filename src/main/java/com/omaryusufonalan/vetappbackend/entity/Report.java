package com.omaryusufonalan.vetappbackend.entity;

import com.omaryusufonalan.vetappbackend.core.EntityTemplate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Report extends EntityTemplate {
    private String title;

    private String diagnosis;

    private double price;

    @OneToOne
    private Appointment appointment;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "report", cascade = CascadeType.REMOVE)
    private List<Vaccine> vaccines;
}
