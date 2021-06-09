package com.learning.ddd.cinemaBooking.Location.Repository;

import java.util.List;

import com.learning.ddd.cinemaBooking.Location.Models.Location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findAll();
}
