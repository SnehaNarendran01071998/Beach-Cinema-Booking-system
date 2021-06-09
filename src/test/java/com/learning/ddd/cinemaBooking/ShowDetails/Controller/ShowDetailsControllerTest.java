package com.learning.ddd.cinemaBooking.ShowDetails.Controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.learning.ddd.cinemaBooking.CinemaBookingApplication;
import com.learning.ddd.cinemaBooking.ShowDetails.Models.DTO.ShowDetailsDto;
import com.learning.ddd.cinemaBooking.ShowDetails.Service.ShowDetailsService;

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
public class ShowDetailsControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    ShowDetailsService showDetailsService;

    @InjectMocks
    ShowDetailsController showDetailsController;

    @Test
    void shouldReturnListOfShowDetailsGivenAnId() throws Exception {
        // ARRANGE
        ShowDetailsDto showDetailsDto = new ShowDetailsDto() {

            @Override
            public long getId() {
                return 1;
            }

            @Override
            public String getFilm() {
                return "some film";
            }

        };
        List<ShowDetailsDto> mockList = new ArrayList<ShowDetailsDto>();
        mockList.add(showDetailsDto);
        when(showDetailsService.listByLocation(1L)).thenReturn(mockList);
        String expectedJson = "[{\"id\":1,\"film\":\"some film\"}]";

        // ACT
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/showDetails/location?locationId=1")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        String actual = mvcResult.getResponse().getContentAsString();

        // ASSERT
        verify(showDetailsService).listByLocation(1L);
        JSONAssert.assertEquals(expectedJson, actual, false);
    }

}
