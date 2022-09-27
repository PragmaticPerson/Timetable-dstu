package ru.donstu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.donstu.edu.models.Group;
import ru.donstu.edu.models.Timetable;

public interface TimetableJpaRepository extends JpaRepository<Timetable, Integer> {

    List<Timetable> findByGroupOrderByDateAscNumber(Group group);
}
