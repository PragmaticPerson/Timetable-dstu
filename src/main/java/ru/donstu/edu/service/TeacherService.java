package ru.donstu.edu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.donstu.edu.dao.TeacherJpaRepository;
import ru.donstu.edu.models.Teacher;

@Service
public class TeacherService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private TeacherJpaRepository repository;

    @Autowired
    public TeacherService(TeacherJpaRepository repository) {
        super();
        this.repository = repository;
    }

    public Teacher getByName(String name) {
        logger.debug("Getting teacher with name '{}'", name);

        Teacher teacher = repository.findByName(name);
        if (teacher == null) {
            logger.debug("No teacher with name '{}' exist. Creating such", name);
            teacher = repository.save(new Teacher(name));
        }
        return teacher;
    }

}
