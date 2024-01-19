package com.example.cinema.mapper;

import com.example.cinema.dto.CategorieDto;
import com.example.cinema.models.Categorie;

public class CategorieMapper {
    public static Categorie  mapToCategorie(CategorieDto categorieDto) {
        return Categorie.builder()
                .id(categorieDto.getId())
                .films(categorieDto.getFilms())
                .name(categorieDto.getName())
                .build();
    }

    public static CategorieDto mapToCategorieDto(Categorie categorie) {
        return CategorieDto.builder()
                .id(categorie.getId())
                .films(categorie.getFilms())
                .name(categorie.getName())
                .build();
    }

}
