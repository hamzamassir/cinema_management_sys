package com.example.cinema.mapper;

import com.example.cinema.dto.PlaceDto;
import com.example.cinema.models.Place;

public class PlaceMapper {
    public static Place mapToPlace(PlaceDto placeDto) {
        return Place.builder()
                .id(placeDto.getId())
                .numeroPlace(placeDto.getNumeroPlace())
                .salle(placeDto.getSalle())
                .tickets(placeDto.getTickets())
                .build();
    }

    public static PlaceDto mapToPlaceDto(Place place) {
        return PlaceDto.builder()
                .id(place.getId())
                .numeroPlace(place.getNumeroPlace())
                .salle(place.getSalle())
                .tickets(place.getTickets())
                .build();
    }
}
