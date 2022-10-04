package com.emse.spring.faircorp.model;


import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private Integer floor;

    @Column(nullable=false)
    private String name;

    private Double currentTemperature;

    private Double targetTemperature;

    @OneToMany(mappedBy = "room")
    private List<Heater> listHeaters;

    @OneToMany(mappedBy = "room")
    private List<Window> listWindows;

    public Room() {
    }

    public Room(Integer floor, String name) {
        this.floor = floor;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public Long getId() {
        return id;
    }

    public List<Window> getWindows() {
        return this.listWindows;
    }

    public List<Heater> getHeaters() {
        return listHeaters;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public List<Heater> getListHeaters() {
        return listHeaters;
    }

    public void setListHeaters(List<Heater> listHeaters) {
        this.listHeaters = listHeaters;
    }

    public List<Window> getListWindows() {
        return listWindows;
    }

    public void setListWindows(List<Window> listWindows) {
        this.listWindows = listWindows;
    }
}
