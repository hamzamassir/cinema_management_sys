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
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/projections/{projectionId}")
    public String projectionDetail(@PathVariable("projectionId") long projectionId, Model model) {
        ProjectionDto projectionDto = projectionService.findProjectionById(projectionId);
        model.addAttribute("projection", projectionDto);
        return "projections-detail";
    }
    @PostMapping("/confirmReservation/{projectionId}")
    public String confirmReservation(@PathVariable("projectionId") Long projectionId,
                                     @RequestParam("selectedTickets") List<Long> selectedTickets,
                                     @RequestParam("nomClient") String nomClient,
                                     @RequestParam("codePayement") Integer codePayement,
                                     Model model) {

        // Validate the data, perform business logic, and update the reservation status
        // You can call a service method to handle the reservation logic
        projectionService.confirmReservation(projectionId, selectedTickets, nomClient, codePayement);

        // Set the 'projectionId' attribute in the model before redirecting
        model.addAttribute("projectionId", projectionId);

        // Redirect to the projection details page or another appropriate page
        return "redirect:/projections/{projectionId}";
    }
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
