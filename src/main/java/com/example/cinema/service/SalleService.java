package com.example.cinema.service;

import com.example.cinema.dto.SalleDto;
import com.example.cinema.models.Salle;

import java.util.List;

public interface SalleService {
    void saveSalle(Long cinemaId,SalleDto salleDto);

    List<SalleDto> findAllSalles();

    SalleDto findSalleById(Long salleId);

    void updateSalle(SalleDto salle);
}

