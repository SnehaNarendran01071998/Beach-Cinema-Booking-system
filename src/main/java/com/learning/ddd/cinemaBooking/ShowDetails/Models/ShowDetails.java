package com.learning.ddd.cinemaBooking.ShowDetails.Models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.learning.ddd.cinemaBooking.Film.Models.Film;
import com.learning.ddd.cinemaBooking.Models.Room;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "show_details")
public class ShowDetails {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "start_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime startTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id")
    private Film film;

    public ShowDetails(Long id, LocalDateTime startTime, Room room, Film film) {
        this.id = id;
        this.startTime = startTime;
        this.room = room;
        this.film = film;
    }

    protected ShowDetails() {
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Date return the startTime
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * @return List<Room> return the rooms
     */
    public Room getRooms() {
        return room;
    }

    /**
     * @param rooms the rooms to set
     */
    public void setRooms(Room room) {
        this.room = room;
    }

    /**
     * @return Film return the film
     */
    public Film getFilm() {
        return film;
    }

    /**
     * @param film the film to set
     */
    public void setFilm(Film film) {
        this.film = film;
    }

}
