package com.learning.ddd.cinemaBooking.Location.Controller;

import java.util.List;

import com.learning.ddd.cinemaBooking.Location.Models.Location;
import com.learning.ddd.cinemaBooking.Location.Service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "https://cinema-booking-frontend.herokuapp.com" })
@RequestMapping("/location")
public class LocationController {
    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/all")
    public List<Location> list() {
        return locationService.list();
    }

}
