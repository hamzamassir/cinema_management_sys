package com.example.cinema.controller;

import com.example.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CinemaController {
    private CinemaService cinemaService;
    @Autowired
    public CinemaController(CinemaService cinemaService){
        this.cinemaService= cinemaService;
    }
}
