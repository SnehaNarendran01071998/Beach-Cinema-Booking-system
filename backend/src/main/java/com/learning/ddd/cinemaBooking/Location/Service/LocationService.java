package com.learning.ddd.cinemaBooking.Location.Service;
import java.util.List;

import com.learning.ddd.cinemaBooking.Location.Models.Location;
import com.learning.ddd.cinemaBooking.Location.Repository.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    private LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> list() {
        return locationRepository.findAll();
    }

}
