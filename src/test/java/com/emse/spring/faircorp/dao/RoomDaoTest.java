package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.WindowStatus;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class RoomDaoTest {
    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldFindARoom() {
        Room room = roomDao.getReferenceById(-10L);
        Assertions.assertThat(room.getName()).isEqualTo("Room1");
        Assertions.assertThat(room.getCurrentTemperature()).isEqualTo(22.3);
    }

    @Test
    public void shouldFindByName(){
        List<Room> result = roomDao.findRoomByName("Room2");
        Assertions.assertThat(result)
                .hasSize(1)
                .extracting("id")
                .containsExactly(-9L);
    }

    @Test
    public void shouldNotFindByName(){
        List<Room> result = roomDao.findRoomByName("sdxfcgvb");
        Assertions.assertThat(result).isEmpty();
    }
}