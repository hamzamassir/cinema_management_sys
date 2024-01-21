package com.example.cinema.dto;

import com.example.cinema.models.Projection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilmDto {
    private Long id;
    private String titre;
    private double Duree;
    private String realisateur;
    private String description;
    private String photo;
    private String categories;
    private List<Projection> projections;
}