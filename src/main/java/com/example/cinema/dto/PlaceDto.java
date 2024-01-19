package com.example.cinema.dto;

import com.example.cinema.models.Salle;
import com.example.cinema.models.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlaceDto {

    private Long id;
    private int numeroPlace;
    private Salle salle;
    private List<Ticket> tickets;
}
