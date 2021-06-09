package com.learning.ddd.cinemaBooking.Film.Models.DTO;

import java.time.LocalDateTime;

public interface FilmDetailsDto {
    long getId();

    String getFilm();

    int getDuration();

    String getDescription();

    LocalDateTime getStartTime();

    String getTheatre();

}
