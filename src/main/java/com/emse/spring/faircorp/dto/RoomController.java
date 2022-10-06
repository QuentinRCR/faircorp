package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController // (1)
@RequestMapping("/api/rooms") // (2)
@Transactional // (3)
public class RoomController {


    private final RoomDao roomDao;


    public RoomController(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null); // (7)
    }

    @GetMapping // (5)
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());  // (6)
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        roomDao.deleteById(id);
    }

    @PostMapping // (8)
    public RoomDto create(@RequestBody RoomDto dto) {
        Room room = null;
        if (dto.getId() == null) {
            room = roomDao.save(new Room(dto.getFloor(),dto.getName()));
        }
        else {
            room = roomDao.getById(dto.getId());  // (9)
            room.setFloor(dto.getFloor());
            room.setName(dto.getName());
            room.setCurrentTemperature(dto.getCurrentTemperature());
            room.setTargetTemperature(dto.getTargetTemperature());
        }
        return new RoomDto(room);
    }

    @PutMapping(path = "/{id}/switchWindows")
    public RoomDto switchWindows(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        room.getListWindows().forEach(window -> {
            window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
        });
        return new RoomDto(room);
    }

    @PutMapping(path = "/{id}/switchHeaters")
    public RoomDto switchHeaters (@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        room.getListHeaters().forEach(heater -> {
            heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
        });
        return new RoomDto(room);
    }


}
