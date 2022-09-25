package ru.donstu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.donstu.edu.models.Audience;

public interface AudienceJpaRepository extends JpaRepository<Audience, Integer> {

}
