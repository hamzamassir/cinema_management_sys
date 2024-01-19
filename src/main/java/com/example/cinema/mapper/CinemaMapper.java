package com.example.cinema.mapper;

import com.example.cinema.dto.CinemaDto;
import com.example.cinema.models.Cinema;

public class CinemaMapper {
    public static Cinema mapToCinema(CinemaDto cinemaDto) {
        return Cinema.builder()
                .id(cinemaDto.getId())
                .salles(cinemaDto.getSalles())
                .nombreSalles(cinemaDto.getNombreSalles())
                .name(cinemaDto.getName())
                .build();
    }

    public static CinemaDto mapToCinemaDto(Cinema cinema) {
        return CinemaDto.builder()
                .id(cinema.getId())
                .salles(cinema.getSalles())
                .nombreSalles(cinema.getNombreSalles())
                .name(cinema.getName())
                .build();
    }
}
