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
public class Doctor extends EntityTemplate {
    private String name;

    @Column(unique = true)
    private String phone;

    @Column(unique = true)
    private String email;

    private String address;

    private String city;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "doctor", cascade = CascadeType.REMOVE)
    private List<AvailableDate> availableDates;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "doctor", cascade = CascadeType.REMOVE)
    private List<Appointment> appointments;
}
