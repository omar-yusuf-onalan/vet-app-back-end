package com.omaryusufonalan.vetappbackend.entity;

import com.omaryusufonalan.vetappbackend.core.EntityTemplate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vaccine extends EntityTemplate {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String code;

    private LocalDate protectionStartDate;

    private LocalDate protectionFinishDate;

    @ManyToOne
    private Animal animal;

    @ManyToOne
    private Report report;
}
