package com.example.cinema.service.impl;

import com.example.cinema.dto.SalleDto;
import com.example.cinema.models.Cinema;
import com.example.cinema.models.Place;
import com.example.cinema.models.Salle;
import com.example.cinema.repository.CinemaRepository;
import com.example.cinema.repository.PlaceRepository;
import com.example.cinema.repository.SalleRepository;
import com.example.cinema.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.cinema.mapper.SalleMapper.*;

@Service
public class SalleServiceImpl implements SalleService {
    private SalleRepository salleRepository;
    private CinemaRepository cinemaRepository;
    private PlaceRepository placeRepository;
    @Autowired
    public SalleServiceImpl(SalleRepository salleRepository,
                            CinemaRepository cinemaRepository,
                            PlaceRepository placeRepository){
        this.salleRepository=salleRepository;
        this.cinemaRepository = cinemaRepository;
        this.placeRepository = placeRepository;
    }

    @Override
    public void saveSalle(Long cinemaId,SalleDto salleDto) {
        Cinema cinema = cinemaRepository.findById(cinemaId).get();
        Salle salle = mapToSalle(salleDto);
        salle.setCinema(cinema);
        salleRepository.save(salle);
        /*for (int i = 0; i < salle.getNombrePlaces(); i++) {
            Place place = new Place();
            place.setNumeroPlace(i+1);
            place.setSalle(salle);
            placeRepository.save(place);
        }*/
        List<Place> places = new ArrayList<>();
        for (int i = 0; i < salle.getNombrePlaces(); i++) {
            Place place = new Place();
            place.setNumeroPlace(i + 1);
            place.setSalle(salle);
            places.add(place);
        }

        placeRepository.saveAll(places);
    }

    @Override
    public List<SalleDto> findAllSalles() {
        List<Salle> salles = salleRepository.findAll();
        return salles.stream().map((salle) -> mapToSalleDto(salle)).collect(Collectors.toList());
    }

    @Override
    public SalleDto findSalleById(Long salleId) {
        Salle salle = salleRepository.findById(salleId).get();
        return mapToSalleDto(salle);
    }

    @Override
    public void updateSalle(SalleDto salleDto) {
        Salle salle = mapToSalle(salleDto);
        salleRepository.save(salle);
    }
}
