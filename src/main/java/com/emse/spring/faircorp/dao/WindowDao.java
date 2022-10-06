package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface WindowDao extends JpaRepository<Window, Long>, WindowDaoCustom {

    @Query("select c from Window c where c.id=:id")  // (2)
    Window findByName(@Param("id") String id);

    void deleteByRoomId(Long Id);

}
