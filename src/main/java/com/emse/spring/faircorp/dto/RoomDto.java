package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoomDto {

    private Long id;
    private Integer floor;
    private String name;
    private Double currentTemperature;
    private Double targetTemperature;
    private List<HeaterDto> listHeaters;
    private List<WindowDto> listWindows;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.floor = room.getFloor();
        this.name = room.getName();
        this.id = room.getId();
        this.currentTemperature = room.getCurrentTemperature();
        this.targetTemperature = room.getTargetTemperature();
        if (room.getListHeaters()!=null) {
            this.listHeaters = room.getListHeaters().stream().map(HeaterDto::new).collect(Collectors.toList());
        }
        else{
            this.listHeaters= new ArrayList<HeaterDto>();
        }
        if (room.getListWindows()!=null) {
            this.listWindows = room.getListWindows().stream().map(WindowDto::new).collect(Collectors.toList());
        }
        else{
            this.listWindows= new ArrayList<WindowDto>();
        }

    }

    public Long getId() {
        return id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
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

    public List<HeaterDto> getListHeaters() {
        return listHeaters;
    }

    public void setListHeaters(List<HeaterDto> listHeaters) {
        this.listHeaters = listHeaters;
    }

    public List<WindowDto> getListWindows() {
        return listWindows;
    }

    public void setListWindows(List<WindowDto> listWindows) {
        this.listWindows = listWindows;
    }
}
