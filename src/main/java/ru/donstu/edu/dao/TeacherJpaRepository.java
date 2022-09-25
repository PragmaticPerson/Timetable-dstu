package ru.donstu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.donstu.edu.models.Teacher;

public interface TeacherJpaRepository extends JpaRepository<Teacher, Integer> {

}
