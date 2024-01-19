package com.example.cinema.dto;


import com.example.cinema.models.Film;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategorieDto {
    private Long id;
    private String name;
    private List<Film> films;
}