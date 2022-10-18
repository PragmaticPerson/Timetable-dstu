package ru.donstu.edu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.donstu.edu.dao.SubjectJpaRepository;
import ru.donstu.edu.models.Subject;

@Service
public class SubjectService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private SubjectJpaRepository repository;

    @Autowired
    public SubjectService(SubjectJpaRepository repository) {
        super();
        this.repository = repository;
    }

    public Subject getByName(String name) {
        logger.debug("Getting subject with name '{}'", name);

        Subject subject = repository.findByName(name);
        if (subject == null) {
            logger.debug("No subject with name '{}' exist. Creating such", name);
            subject = repository.save(new Subject(name));
        }
        return subject;
    }
}
