package com.example.cinema.service.impl;

import com.example.cinema.dto.FilmDto;
import com.example.cinema.models.Film;
import com.example.cinema.models.Salle;
import com.example.cinema.repository.CinemaRepository;
import com.example.cinema.repository.FilmRepository;
import com.example.cinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.cinema.mapper.FilmMapper.*;
import static com.example.cinema.mapper.SalleMapper.mapToSalleDto;

@Service
public class FilmServiceImpl implements FilmService {
    private FilmRepository filmRepository ;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public List<FilmDto> findAllFilms() {
        List<Film> films = filmRepository.findAll();
        return films.stream().map((film) -> mapToFilmDto(film)).collect(Collectors.toList());
    }

    @Override
    public void saveFilm(FilmDto filmDto) {
        Film film = mapToFilm(filmDto);
        filmRepository.save(film);
    }

    @Override
    public FilmDto findFilmById(long filmId) {
        Film film = filmRepository.findById(filmId).get();
        return mapToFilmDto(film);
    }
}
