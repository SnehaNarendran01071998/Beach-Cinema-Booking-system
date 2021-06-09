package com.learning.ddd.cinemaBooking.Film.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import com.learning.ddd.cinemaBooking.Film.Models.DTO.FilmDetailsDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@Transactional
public class FilmRepositoryTest {
    @Autowired
    FilmRepository filmRepository;

    @Test
    @Sql(scripts = { "classpath:insertFilms.sql" })
    public void shouldGetFilmsByFilmId() {
        // ARRANGE
        // ACT
        List<FilmDetailsDto> findByFilm = filmRepository.findByFilm(1L);

        // ASSERT
        assertEquals(1L, findByFilm.get(0).getId());
    }

}
