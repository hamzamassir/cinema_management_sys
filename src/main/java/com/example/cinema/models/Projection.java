package com.example.cinema.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateProjection;
    private Double prix;

    @Transient
    private Long salleId;  // Transient field for film ID
    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;


    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @OneToMany(mappedBy = "projection")
    private List<Ticket> tickets= new ArrayList<>();
    private String seance;
}
