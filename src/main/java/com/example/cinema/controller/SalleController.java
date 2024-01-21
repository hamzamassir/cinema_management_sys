package com.example.cinema.controller;

import com.example.cinema.dto.SalleDto;
import com.example.cinema.models.Salle;
import com.example.cinema.service.CinemaService;
import com.example.cinema.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SalleController {
    private SalleService salleService;
    private CinemaService cinemaService;
    @Autowired
    public SalleController(SalleService salleService,CinemaService cinemaService
    ){
        this.salleService = salleService;
        this.cinemaService = cinemaService;
    }
    @GetMapping("/salles/{cinemaId}/new")
    public String createSalleForm(@PathVariable("cinemaId") Long cinemaId, Model model) {
        Salle salle = new Salle();
        model.addAttribute("cinemaId", cinemaId);
        model.addAttribute("salle",salle);
        return "salles-create";
    }
    @PostMapping("/salles/{cinemaId}")
    public String createSalle( @PathVariable("cinemaId") Long cinemaId,@ModelAttribute("salle") SalleDto salleDto, BindingResult result, Model model) {
        if(result.hasErrors()) {

            model.addAttribute("salle", salleDto);
            return "salles-create";
        }
        salleService.saveSalle(cinemaId,salleDto);
        return "redirect:/salles";
    }
    @GetMapping("/salles")
    public String listSalles(Model model) {

        List<SalleDto> salles = salleService.findAllSalles();
        model.addAttribute("salles", salles);
        return "salles-list";
    }
    @GetMapping("/salles/{salleId}/edit")
    public String editSalleForm(@PathVariable("salleId") Long salleId, Model model) {
        SalleDto salle = salleService.findSalleById(salleId);
        model.addAttribute("salle", salle);
        return "salles-edit";
    }
    @PostMapping("/salles/{salleId}/edit")
    public String updateSalle(@PathVariable("salleId") Long salleId,
                              @ModelAttribute("salle") SalleDto salle,
                             BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("salle", salle);
            return "salles-edit";
        }
        salle.setId(salleId);
        salleService.updateSalle(salle);
        return "redirect:/salles";
    }
    @GetMapping("/salles/{salleId}")
    public String salleDetail(@PathVariable("salleId") long salleId, Model model) {
        SalleDto salleDto = salleService.findSalleById(salleId);
        model.addAttribute("salle", salleDto);
        return "salles-detail";
    }
}
