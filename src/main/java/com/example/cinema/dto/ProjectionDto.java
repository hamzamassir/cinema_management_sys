package com.example.cinema.dto;

import com.example.cinema.models.Film;
import com.example.cinema.models.Salle;
import com.example.cinema.models.Seance;
import com.example.cinema.models.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProjectionDto {

    private Long id;
    private Date dateProjection;
    private Double prix;
    private Salle salle;
    private Film film;
    private List<Ticket> tickets;
    private Seance seance;
}
