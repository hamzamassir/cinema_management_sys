package com.example.cinema.controller;

import com.example.cinema.dto.FilmDto;
import com.example.cinema.dto.SalleDto;
import com.example.cinema.models.Film;
import com.example.cinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FilmController {

    private FilmService filmService;
    @Autowired
    public FilmController(FilmService filmService){
        this.filmService= filmService;
    }
    /*@GetMapping("/categories/new")
    public String createSalleForm(Model model) {
        Categorie categorie = new Categorie();
        model.addAttribute("categorie",categorie);
        return "categories-create";
    }
    @PostMapping("/categories/create")
    public String createSalle(@ModelAttribute("categorie") CategorieDto categorieDto, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("categorie", categorieDto);
            return "categories-create";
        }
        categorieService.saveCategorie(categorieDto);
        return "redirect:/categories";
    }
    @GetMapping("/categories")
    public String listcategories(Model model) {

        List<CategorieDto> categories = categorieService.findAllCategories();
        model.addAttribute("categories", categories);
        return "categories-list";
    }*/
    @GetMapping("/films/new")
    public String createFilmForm(Model model) {
        Film film = new Film();
        model.addAttribute("film",film);
        return "films-create";
    }
    @PostMapping("/films/create")
    public String createFilm(@ModelAttribute("film") FilmDto filmDto, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("film", filmDto);
            return "films-create";
        }
        filmService.saveFilm(filmDto);
        return "redirect:/films";
    }
    @GetMapping("/films")
    public String listfilms(Model model) {

        List<FilmDto> films = filmService.findAllFilms();
        model.addAttribute("films", films);
        return "films-list";
    }
    @GetMapping("/films/{filmId}")
    public String filmDetail(@PathVariable("filmId") long filmId, Model model) {
        FilmDto filmDto = filmService.findFilmById(filmId);
        model.addAttribute("film", filmDto);
        return "films-detail";
    }
}
