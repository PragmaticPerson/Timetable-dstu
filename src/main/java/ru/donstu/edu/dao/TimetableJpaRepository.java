package ru.donstu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.donstu.edu.models.Group;
import ru.donstu.edu.models.Timetable;

public interface TimetableJpaRepository extends JpaRepository<Timetable, Integer> {

    List<Timetable> findByGroupOrderByDateAscNumber(Group group);

    @Modifying
    @Query("DELETE FROM Timetable t WHERE t.group.id = :id")
    void deleteAllByGroup(@Param("id") int id);
}
