package com.example.cinema.service.impl;

import com.example.cinema.dto.ProjectionDto;
import com.example.cinema.models.*;
import com.example.cinema.repository.FilmRepository;
import com.example.cinema.repository.ProjectionRepository;
import com.example.cinema.repository.TicketRepository;
import com.example.cinema.service.ProjectionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.cinema.mapper.FilmMapper.mapToFilmDto;
import static com.example.cinema.mapper.ProjectionMapper.*;
import static com.example.cinema.mapper.SalleMapper.mapToSalleDto;

@Service
public class ProjectionServiceImpl implements ProjectionService {
    private ProjectionRepository projectionRepository;
    private FilmRepository filmRepository;
    private TicketRepository ticketRepository;
    @Autowired
    public ProjectionServiceImpl(ProjectionRepository projectionRepository,
                                 FilmRepository filmRepository,
                                 TicketRepository ticketRepository){
        this.projectionRepository=projectionRepository;
        this.filmRepository = filmRepository;
        this.ticketRepository=ticketRepository;
    }

    @Override
    public void saveProjection(Long filmId, ProjectionDto projectionDto) {
        Film film = filmRepository.findById(filmId).get();
        Projection projection = mapToProjection(projectionDto);
        projection.setFilm(film);
        projectionRepository.save(projection);
        projection.getSalle().getPlaces().forEach(place -> {
            Ticket ticket = new Ticket();
            ticket.setPlace(place);
            ticket.setPrix(projection.getPrix());
            ticket.setProjection(projection);
            ticket.setReserver(false);
            ticketRepository.save(ticket);
        });

    }

    @Override
    public List<ProjectionDto> findAllProjections() {
        List<Projection> projections = projectionRepository.findAll();
        return projections.stream().map((projection) -> mapToProjectionDto(projection)).collect(Collectors.toList());
    }

    @Override
    public ProjectionDto findProjectionById(long projectionId) {
        Projection projection = projectionRepository.findById(projectionId).get();
        return mapToProjectionDto(projection);
    }

    @Transactional
    public void confirmReservation(Long projectionId, List<Long> selectedTickets, String nomClient, Integer codePayement) {
        // Retrieve the projection
        Projection projection = projectionRepository.findById(projectionId)
                .orElseThrow(() -> new EntityNotFoundException("Projection not found"));

        // Update the reservation status of selected tickets
        for (Long ticketId : selectedTickets) {
            Ticket ticket = projection.getTickets().stream()
                    .filter(t -> t.getId().equals(ticketId))
                    .findFirst()
                    .orElseThrow(() -> new EntityNotFoundException("Ticket not found"));

            if (!ticket.getReserver()) {
                // Ticket is not reserved, proceed with reservation
                ticket.setReserver(true);
                ticket.setNomClient(nomClient);
                ticket.setCodePayement(codePayement);
                // Perform any additional logic as needed
            }
        }

        // Save the updated projection
        projectionRepository.save(projection);
    }
}

