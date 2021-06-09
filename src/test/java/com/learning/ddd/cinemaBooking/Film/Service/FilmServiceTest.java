package com.learning.ddd.cinemaBooking.Film.Service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.learning.ddd.cinemaBooking.CinemaBookingApplication;
import com.learning.ddd.cinemaBooking.Film.Models.DTO.FilmDetailsDto;
import com.learning.ddd.cinemaBooking.Film.Repository.FilmRepository;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CinemaBookingApplication.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class FilmServiceTest {
    @Mock
    FilmRepository filmRepository;

    @InjectMocks
    FilmService filmService;

    private ArrayList<FilmDetailsDto> filmDetailsList;

    @Test
    public void shouldCallFindByFilm() {
        // ARRANGE
        FilmDetailsDto filmDetailsDto = new FilmDetailsDto() {
            @Override
            public String getDescription() {
                return "some description";
            }

            @Override
            public long getId() {
                return 1;
            }

            @Override
            public String getFilm() {
                return "some-film";
            }

            @Override
            public int getDuration() {
                return 190;
            }

            @Override
            public LocalDateTime getStartTime() {
                return LocalDateTime.parse("2016-02-26T23:55:42.123");
            }

            @Override
            public String getTheatre() {
                return "A Theatre";
            }
        };
        filmDetailsList = new ArrayList<FilmDetailsDto>();
        filmDetailsList.add(filmDetailsDto);
        when(filmRepository.findByFilm(1L)).thenReturn(filmDetailsList);

        // ACT
        filmService.findByFilm(1L);

        // ASSERT
        verify(filmRepository).findByFilm(1L);
    }

}
