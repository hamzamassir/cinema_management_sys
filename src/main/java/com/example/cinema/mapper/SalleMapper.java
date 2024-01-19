package com.example.cinema.mapper;

import com.example.cinema.dto.SalleDto;
import com.example.cinema.models.Salle;

public class SalleMapper {
    public static Salle mapToSalle(SalleDto salleDto ) {
        return Salle.builder()
                .id(salleDto.getId())
                .name(salleDto.getName())
                .nombrePlaces(salleDto.getNombrePlaces())
                .cinema(salleDto.getCinema())
                .places(salleDto.getPlaces())
                .projections(salleDto.getProjections())
                .build();
    }

    public static SalleDto mapToSalleDto(Salle salle) {
        return SalleDto.builder()
                .id(salle.getId())
                .name(salle.getName())
                .nombrePlaces(salle.getNombrePlaces())
                .cinema(salle.getCinema())
                .places(salle.getPlaces())
                .projections(salle.getProjections())
                .build();
    }
}
