package ru.donstu.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.donstu.edu.dao.AudienceJpaRepository;
import ru.donstu.edu.models.Audience;

@Service
public class AudienceService {

    private AudienceJpaRepository repository;

    @Autowired
    public AudienceService(AudienceJpaRepository repository) {
        super();
        this.repository = repository;
    }

    public Audience getByName(String name) {
        Audience audience = repository.findByName(name);
        if (audience == null) {
            audience = repository.save(new Audience(name));
        }
        return audience;
    }
}
