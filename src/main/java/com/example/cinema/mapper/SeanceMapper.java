package com.example.cinema.mapper;

import com.example.cinema.dto.SeanceDto;
import com.example.cinema.models.Seance;

public class SeanceMapper {
    public static Seance mapToSeance(SeanceDto seanceDto) {
        return Seance.builder()
                .id(seanceDto.getId())
                .heureDebut(seanceDto.getHeureDebut())
                .build();
    }

    public static SeanceDto mapToSeanceDto(Seance seance) {
        return SeanceDto.builder()
                .id(seance.getId())
                .heureDebut(seance.getHeureDebut())
                .build();
    }
}
