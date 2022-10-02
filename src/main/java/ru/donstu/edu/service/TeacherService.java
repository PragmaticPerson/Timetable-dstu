package ru.donstu.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.donstu.edu.dao.TeacherJpaRepository;
import ru.donstu.edu.models.Teacher;

@Service
public class TeacherService {

    private TeacherJpaRepository repository;

    @Autowired
    public TeacherService(TeacherJpaRepository repository) {
        super();
        this.repository = repository;
    }

    public Teacher getByName(String name) {
        Teacher teacher = repository.findByName(name);
        if (teacher == null) {
            teacher = repository.save(new Teacher(name));
        }
        return teacher;
    }

}
