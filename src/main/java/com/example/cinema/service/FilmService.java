package com.example.cinema.service;

import com.example.cinema.dto.FilmDto;

import java.util.List;

public interface FilmService {
    List<FilmDto> findAllFilms();

    void saveFilm(FilmDto filmDto);

    FilmDto findFilmById(long filmId);
}
