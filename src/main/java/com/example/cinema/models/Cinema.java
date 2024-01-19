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
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int nombreSalles;
    @OneToMany(mappedBy = "cinema")
    private List<Salle> salles = new ArrayList<>();
}
