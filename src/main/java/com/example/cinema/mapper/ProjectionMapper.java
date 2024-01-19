package com.example.cinema.mapper;

import com.example.cinema.dto.ProjectionDto;
import com.example.cinema.models.Projection;

public class ProjectionMapper {
    public static Projection mapToProjection(ProjectionDto projectionDto) {
        return Projection.builder()
                .id(projectionDto.getId())
                .dateProjection(projectionDto.getDateProjection())
                .prix(projectionDto.getPrix())
                .film(projectionDto.getFilm())
                .salle(projectionDto.getSalle())
                .seance(projectionDto.getSeance())
                .tickets(projectionDto.getTickets())
                .build();
    }

    public static ProjectionDto mapToProjectionDto(Projection projection) {
        return ProjectionDto.builder()
                .id(projection.getId())
                .dateProjection(projection.getDateProjection())
                .prix(projection.getPrix())
                .film(projection.getFilm())
                .salle(projection.getSalle())
                .seance(projection.getSeance())
                .tickets(projection.getTickets())
                .build();
    }
}
