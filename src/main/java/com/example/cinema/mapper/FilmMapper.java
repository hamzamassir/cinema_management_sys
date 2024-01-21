package com.example.cinema.mapper;

import com.example.cinema.dto.FilmDto;
import com.example.cinema.models.Film;

public class FilmMapper {
    public static Film mapToFilm(FilmDto filmDto) {
        return Film.builder()
                .id(filmDto.getId())
                .titre(filmDto.getTitre())
                .Duree(filmDto.getDuree())
                .categories(filmDto.getCategories())
                .description(filmDto.getDescription())
                .photo(filmDto.getPhoto())
                .realisateur(filmDto.getRealisateur())
                .projections(filmDto.getProjections())
                .build();
    }

    public static FilmDto mapToFilmDto(Film film) {
        return FilmDto.builder()
                .id(film.getId())
                .titre(film.getTitre())
                .Duree(film.getDuree())
                .categories(film.getCategories())
                .description(film.getDescription())
                .photo(film.getPhoto())
                .realisateur(film.getRealisateur())
                .projections(film.getProjections())
                .build();
    }
}
