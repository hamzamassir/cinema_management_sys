package com.example.cinema.dto;

import com.example.cinema.models.Cinema;
import com.example.cinema.models.Place;
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
public class SalleDto {
    private Long id;
    private String name;
    private int nombrePlaces;
    private Cinema cinema;
    private List<Place> places;
    private List<Projection> projections;
}
