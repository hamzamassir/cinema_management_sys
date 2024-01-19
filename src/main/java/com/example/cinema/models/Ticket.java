package com.example.cinema.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nomClient;
    private Double prix;
    @Column(unique = false,nullable = true)
    private Integer codePayement;
    private Boolean reserver;
    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;
    @ManyToOne
    @JoinColumn(name = "projection_id")
    /*@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)*/
    private Projection projection;
}
