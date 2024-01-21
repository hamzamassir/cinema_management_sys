package com.example.cinema.service;

import com.example.cinema.dto.ProjectionDto;

import java.util.List;

public interface ProjectionService {
    void saveProjection(Long filmId, ProjectionDto projectionDto);

    List<ProjectionDto> findAllProjections();

    ProjectionDto findProjectionById(long projectionId);

    void confirmReservation(Long projectionId, List<Long> selectedTickets, String nomClient, Integer codePayement);
}
