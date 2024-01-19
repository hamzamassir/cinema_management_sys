package com.example.cinema.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private double Duree;
    private String realisateur;
    private String description;
    private String photo;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @OneToMany(mappedBy = "film")
    /*@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) */ // ignore this field when we read, and dont ignore it when we write
    private List<Projection> projections = new ArrayList<>();
}
