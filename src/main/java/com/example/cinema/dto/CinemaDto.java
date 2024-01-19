package com.example.cinema.dto;

import com.example.cinema.models.Salle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CinemaDto {
    private Long id;
    private String name;
    private int nombreSalles;
    private List<Salle> salles;
}
