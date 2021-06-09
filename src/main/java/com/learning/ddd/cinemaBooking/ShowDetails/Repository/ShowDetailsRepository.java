package com.learning.ddd.cinemaBooking.ShowDetails.Repository;

import java.util.List;

import javax.transaction.Transactional;

import com.learning.ddd.cinemaBooking.ShowDetails.Models.ShowDetails;
import com.learning.ddd.cinemaBooking.ShowDetails.Models.DTO.ShowDetailsDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowDetailsRepository extends JpaRepository<ShowDetails, Long> {
    String FIND_BY_LOCATION_QUERY = "select f.id as id, f.name as film from films f join show_details sd on f.id = sd.film_id join rooms r on sd.room_id = r.id join screenings s on s.id = r.screening_id join locations l on l.id = s.location_id where location_id = ?1 group by f.name, f.id";

    @Transactional
    @Query(value = FIND_BY_LOCATION_QUERY, nativeQuery = true)
    List<ShowDetailsDto> findByLocation(Long id);

}
