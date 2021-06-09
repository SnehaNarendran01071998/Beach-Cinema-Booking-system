package com.learning.ddd.cinemaBooking.Film.Controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.learning.ddd.cinemaBooking.CinemaBookingApplication;
import com.learning.ddd.cinemaBooking.Film.Models.DTO.FilmDetailsDto;
import com.learning.ddd.cinemaBooking.Film.Service.FilmService;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(classes = CinemaBookingApplication.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class FilmControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    FilmService filmService;

    @InjectMocks
    FilmController filmController;

    @Test
    void shouldReturnListOfFilmsGivenAnId() throws Exception {
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
        List<FilmDetailsDto> mockList = new ArrayList<FilmDetailsDto>();
        mockList.add(filmDetailsDto);
        when(filmService.findByFilm(1L)).thenReturn(mockList);
        String expectedJson = "[{\"film\":\"some-film\",\"id\":1,\"duration\":190,\"startTime\":\"2016-02-26T23:55:42.123\",\"description\":\"some description\",\"theatre\":\"A Theatre\"}]";

        // ACT
        MvcResult mvcResult = mvc
                .perform(MockMvcRequestBuilders.get("/films/film?filmId=1").accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        String actual = mvcResult.getResponse().getContentAsString();

        // ASSERT
        verify(filmService).findByFilm(1L);
        JSONAssert.assertEquals(expectedJson, actual, false);
    }

}
