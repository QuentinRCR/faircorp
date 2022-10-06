package com.emse.spring.faircorp.model;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
public class Heater {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String name;


    private Long power;

    @Enumerated(EnumType.STRING)
    private HeaterStatus heaterStatus;

    @ManyToOne
    @JoinColumn(nullable=false)
    public Room room;

    public Heater() {
    }

    public Heater(String name, HeaterStatus heaterStatus, Room room) {
        this.name = name;
        this.room = room;
        this.heaterStatus=heaterStatus;
    }

    public String getName() {
        return name;
    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
