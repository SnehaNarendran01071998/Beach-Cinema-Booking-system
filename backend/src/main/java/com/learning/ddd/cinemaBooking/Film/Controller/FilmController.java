package com.learning.ddd.cinemaBooking.Film.Controller;

import java.util.List;

import com.learning.ddd.cinemaBooking.Film.Models.DTO.FilmDetailsDto;
import com.learning.ddd.cinemaBooking.Film.Service.FilmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:8080"})
@RequestMapping("/films")
public class FilmController {
    private FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/film") 
    public List<FilmDetailsDto> findByFilm(@RequestParam("filmId") Long filmId){
        return filmService.findByFilm(filmId);
    }

}
