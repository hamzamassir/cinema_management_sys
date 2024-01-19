package com.example.cinema.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Projection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateProjection;
    private Double prix;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @OneToMany(mappedBy = "projection")
    private List<Ticket> tickets= new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "seance_id")
    private Seance seance;
}
