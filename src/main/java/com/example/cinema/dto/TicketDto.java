package com.example.cinema.dto;

import com.example.cinema.models.Place;
import com.example.cinema.models.Projection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
    private Long id;
    private  String nomClient;
    private Double prix;
    private Integer codePayement;
    private Boolean reserver;
    private Place place;
    private Projection projection;
}
