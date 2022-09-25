package ru.donstu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.donstu.edu.models.Group;

public interface GroupJpaRepository extends JpaRepository<Group, Integer> {

}
