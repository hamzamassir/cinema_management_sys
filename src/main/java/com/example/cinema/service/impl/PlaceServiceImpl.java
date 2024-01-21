package com.example.cinema.service.impl;

import com.example.cinema.repository.PlaceRepository;
import com.example.cinema.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements PlaceService {
    private PlaceRepository placeRepository;
    @Autowired
    public PlaceServiceImpl(PlaceRepository placeRepository){
        this.placeRepository=placeRepository;
    }
}
