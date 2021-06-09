package com.learning.ddd.cinemaBooking.Film.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.ddd.cinemaBooking.ShowDetails.Models.ShowDetails;

@Entity
@Table(name = "films")
public class Film {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private int duration;

    @Column(name = "description")
    private String description;

    public Film(Long id, String name, int duration, String description) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.description = description;
    }

    @OneToMany(mappedBy = "film")
    @JsonIgnore
    private List<ShowDetails> showDetails;

    protected Film() {
    }
    
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
     * @return List<ShowDetails> return the showDetails
     */
    public List<ShowDetails> getShowDetails() {
        return showDetails;
    }

    /**
     * @param showDetails the showDetails to set
     */
    public void setShowDetails(List<ShowDetails> showDetails) {
        this.showDetails = showDetails;
    }


    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
