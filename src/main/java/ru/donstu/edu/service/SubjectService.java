package ru.donstu.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.donstu.edu.dao.SubjectJpaRepository;
import ru.donstu.edu.models.Subject;

@Service
public class SubjectService {

    private SubjectJpaRepository repository;

    @Autowired
    public SubjectService(SubjectJpaRepository repository) {
        super();
        this.repository = repository;
    }

    public Subject getByName(String name) {
        Subject subject = repository.findByName(name);
        if (subject == null) {
            subject = repository.save(new Subject(name));
        }
        return subject;
    }
}
