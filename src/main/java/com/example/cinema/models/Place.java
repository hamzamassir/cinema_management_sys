package com.example.cinema.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numeroPlace;
    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;
    @OneToMany(mappedBy = "place")
    /*@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)*/
    private List<Ticket> tickets = new ArrayList<>();
}
