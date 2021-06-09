package com.learning.ddd.cinemaBooking.Film.Service;

import java.util.List;

import com.learning.ddd.cinemaBooking.Film.Models.DTO.FilmDetailsDto;
import com.learning.ddd.cinemaBooking.Film.Repository.FilmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
    private FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<FilmDetailsDto> findByFilm(Long filmId) {
        return  filmRepository.findByFilm(filmId);
    }

}
