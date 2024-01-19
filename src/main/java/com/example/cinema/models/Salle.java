package com.example.cinema.models;

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
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int nombrePlaces;
    @ManyToOne
    /*@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)*/
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;
    @OneToMany(mappedBy = "salle")
    /*@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)*/
    private List<Place> places = new ArrayList<>();
    @OneToMany(mappedBy = "salle")
    /*@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)*/
    private List<Projection> projections= new ArrayList<>();
}
