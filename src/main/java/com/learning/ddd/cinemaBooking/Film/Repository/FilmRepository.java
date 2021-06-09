package com.learning.ddd.cinemaBooking.Film.Repository;

import java.util.List;

import javax.transaction.Transactional;

import com.learning.ddd.cinemaBooking.Film.Models.Film;
import com.learning.ddd.cinemaBooking.Film.Models.DTO.FilmDetailsDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    String FIND_BY_FILM_QUERY = "select f.id as id, f.name as film, f.duration as duration, f.description as description, sd.start_time as startTime, s.name as theatre from films f join show_details sd on f.id = sd.film_id join rooms r on sd.room_id = r.id join screenings s on s.id = r.screening_id where f.id = ?1";

    @Transactional
    @Query(value = FIND_BY_FILM_QUERY, nativeQuery = true)
    List<FilmDetailsDto> findByFilm(Long id);
}
