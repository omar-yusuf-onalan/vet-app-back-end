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
public class Customer extends EntityTemplate {
    private String name;

    @Column(unique = true)
    private String phone;

    @Column(unique = true)
    private String email;

    private String address;

    private String city;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<Animal> animals;
}
