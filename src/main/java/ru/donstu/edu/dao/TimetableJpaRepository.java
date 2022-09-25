package ru.donstu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.donstu.edu.models.Timetable;

public interface TimetableJpaRepository extends JpaRepository<Timetable, Integer> {

}
