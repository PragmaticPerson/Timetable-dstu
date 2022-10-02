package ru.donstu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.donstu.edu.models.Subject;

public interface SubjectJpaRepository extends JpaRepository<Subject, Integer> {

    public Subject findByName(String name);
}
