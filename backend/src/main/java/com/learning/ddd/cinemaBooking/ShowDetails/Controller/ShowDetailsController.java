package com.learning.ddd.cinemaBooking.ShowDetails.Controller;

import java.util.List;

import com.learning.ddd.cinemaBooking.ShowDetails.Models.DTO.ShowDetailsDto;
import com.learning.ddd.cinemaBooking.ShowDetails.Service.ShowDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:8080"})
@RequestMapping("/showDetails")
public class ShowDetailsController {
    private ShowDetailsService showDetailsService;

    @Autowired
    public ShowDetailsController(ShowDetailsService showDetailsService) {
        this.showDetailsService = showDetailsService;
    }

    @GetMapping("/location") 
    public List<ShowDetailsDto> list(@RequestParam("locationId") Long locationId){
        return showDetailsService.listByLocation(locationId);
    }

}
