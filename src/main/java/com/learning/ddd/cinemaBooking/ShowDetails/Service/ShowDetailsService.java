package com.learning.ddd.cinemaBooking.ShowDetails.Service;

import java.util.List;

import com.learning.ddd.cinemaBooking.ShowDetails.Models.DTO.ShowDetailsDto;
import com.learning.ddd.cinemaBooking.ShowDetails.Repository.ShowDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowDetailsService {
    private ShowDetailsRepository showDetailsRepository;

    @Autowired
    public ShowDetailsService(ShowDetailsRepository showDetailsRepository) {
        this.showDetailsRepository = showDetailsRepository;
    }

    public List<ShowDetailsDto> listByLocation(Long locationId) {
        return showDetailsRepository.findByLocation(locationId);
    }

}
