package com.example.cinema.controller;

import com.example.cinema.dto.FilmDto;
import com.example.cinema.dto.ProjectionDto;
import com.example.cinema.dto.SalleDto;
import com.example.cinema.models.Film;
import com.example.cinema.models.Projection;
import com.example.cinema.models.Salle;
import com.example.cinema.service.FilmService;
import com.example.cinema.service.ProjectionService;
import com.example.cinema.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import static com.example.cinema.mapper.SalleMapper.*;

import java.util.List;

@Controller

public class ProjectionController {
    private ProjectionService projectionService;
    private SalleService salleService;
    @Autowired
    public ProjectionController(ProjectionService projectionService,
                                SalleService salleService){
        this.projectionService = projectionService;
        this.salleService = salleService;
    }
    @GetMapping("/films/{filmId}/projections/new")
    public String createProjectionForm(@PathVariable("filmId") Long filmId, Model model) {
        ProjectionDto projection = new ProjectionDto();
        List<SalleDto> salles = salleService.findAllSalles();
        model.addAttribute("salles", salles);
        model.addAttribute("filmId", filmId);
        model.addAttribute("projection",projection);
        return "projections-create";
    }
    @PostMapping("/films/{filmId}/projections")
    public String createProjection(@PathVariable("filmId") Long filmId,
                                   @ModelAttribute("projection") ProjectionDto projectionDto,
                                   BindingResult result,
                                   Model model) {
        Long selectedSalleId = projectionDto.getSalleId();

        SalleDto selectedSalleDto = salleService.findSalleById(selectedSalleId);
        Salle selectedSalle = mapToSalle(selectedSalleDto);
        projectionDto.setSalle(selectedSalle);
        if(result.hasErrors()) {

            model.addAttribute("projection", projectionDto);
            return "projections-create";
        }
        projectionService.saveProjection(filmId,projectionDto);
        return "redirect:/projections";
    }
    @GetMapping("/projections")
    public String listProjections(Model model) {

        List<ProjectionDto> projections = projectionService.findAllProjections();
        model.addAttribute("projections", projections);
        return "projections-list";
    }
}
