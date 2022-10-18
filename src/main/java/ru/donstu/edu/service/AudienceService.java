package ru.donstu.edu.service;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.donstu.edu.dao.AudienceJpaRepository;
import ru.donstu.edu.models.Audience;

@Service
public class AudienceService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private AudienceJpaRepository repository;

    @Autowired
    public AudienceService(AudienceJpaRepository repository) {
        super();
        this.repository = repository;
    }

    public Audience getById(int id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("No entity with id " + id));
    }

    public Audience getByName(String name) {
        logger.debug("Getting audience with name '{}'", name);

        Audience audience = repository.findByName(name);
        if (audience == null) {
            logger.debug("No audience with name '{}' exist. Creating such", name);
            audience = repository.save(new Audience(name));
        }
        return audience;
    }
}
