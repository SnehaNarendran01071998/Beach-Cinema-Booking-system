package com.learning.ddd.cinemaBooking.ShowDetails.Service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.learning.ddd.cinemaBooking.CinemaBookingApplication;
import com.learning.ddd.cinemaBooking.ShowDetails.Models.DTO.ShowDetailsDto;
import com.learning.ddd.cinemaBooking.ShowDetails.Repository.ShowDetailsRepository;

import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CinemaBookingApplication.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ShowDetailsServiceTest {
    @Mock
    ShowDetailsRepository showDetailsRepository;

    @InjectMocks
    ShowDetailsService showDetailsService;

    private ArrayList<ShowDetailsDto> showDetailsDtoList;

    @Test
    public void shouldCallFindByLocation() {
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
        showDetailsDtoList = new ArrayList<ShowDetailsDto>();
        showDetailsDtoList.add(showDetailsDto);
        when(showDetailsRepository.findByLocation(1L)).thenReturn(showDetailsDtoList);

        // ACT
        showDetailsService.listByLocation(1L);

        // ASSERT
        verify(showDetailsRepository).findByLocation(1L);
    }

}
