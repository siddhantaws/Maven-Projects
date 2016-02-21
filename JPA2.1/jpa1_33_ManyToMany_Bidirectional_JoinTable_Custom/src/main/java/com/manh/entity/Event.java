package com.manh.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Event {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    private int duration;

    // Event is the reverse owner of the relationship
    @ManyToMany(cascade= CascadeType.ALL, mappedBy = "events")
    private Set<Speaker> speakers;

    public void setId(Long id) {
        this.id = id;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setSpeakers(Set speakers) {
        this.speakers = speakers;
    }

    public Set getSpeakers() {
        return speakers;
    }
}
