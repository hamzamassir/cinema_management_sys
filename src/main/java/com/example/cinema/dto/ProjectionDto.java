package com.example.cinema.dto;

import com.example.cinema.models.Film;
import com.example.cinema.models.Salle;
import com.example.cinema.models.Ticket;
import jakarta.persistence.Transient;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProjectionDto {

    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateProjection;
    private Double prix;
    private Long salleId;
    private Salle salle;
    private Film film;
    private List<Ticket> tickets;
    private String seance;
}
