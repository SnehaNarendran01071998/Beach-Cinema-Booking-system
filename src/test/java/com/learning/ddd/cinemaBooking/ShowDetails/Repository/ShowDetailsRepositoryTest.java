package com.learning.ddd.cinemaBooking.ShowDetails.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.learning.ddd.cinemaBooking.ShowDetails.Models.DTO.ShowDetailsDto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@Transactional
public class ShowDetailsRepositoryTest {
    @Autowired
    ShowDetailsRepository showDetailsRepository;

    @Test
    @Sql(scripts = { "classpath:insertFilms.sql" })
    public void shouldGetFilmsByLocationId() {
        // ACT
        List<ShowDetailsDto> findByLocation = showDetailsRepository.findByLocation(2L);

        // ASSERT
        assertEquals(3L, findByLocation.get(0).getId());
        assertEquals("Dear Zindagi", findByLocation.get(0).getFilm());
    }

    @Test
    @Sql(scripts = { "classpath:insertFilms.sql" })
    public void shouldReturnEmptyListIfNoFilmsAreCurrentlyPlayingInTheGivenLocation() {
        // ACT
        List<ShowDetailsDto> findByLocation = showDetailsRepository.findByLocation(1L);

        // ASSERT
        assertEquals(new ArrayList<>(), findByLocation);
    }

}
