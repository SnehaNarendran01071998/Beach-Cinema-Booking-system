package com.learning.ddd.cinemaBooking.Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.ddd.cinemaBooking.ShowDetails.Models.ShowDetails;

@Entity
@Table(name = "rooms")
public class Room {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "no_of_seats")
    private int numberOfSeats;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "screening_id")
    private Screening screening;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private List<ShowDetails> showDetails;

    public Room(Long id, String name, int numberOfSeats) {
        this.id = id;
        this.name = name;
        this.numberOfSeats = numberOfSeats;
    }

    protected Room() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    /**
     * @return Screening return the screening
     */
    public Screening getScreening() {
        return screening;
    }

    /**
     * @param screening the screening to set
     */
    public void setScreening(Screening screening) {
        this.screening = screening;
    }

}
