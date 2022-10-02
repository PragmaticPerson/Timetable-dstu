package ru.donstu.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.donstu.edu.dao.GroupJpaRepository;
import ru.donstu.edu.models.Group;

@Service
public class GroupService {

    private GroupJpaRepository repository;

    @Autowired
    public GroupService(GroupJpaRepository repository) {
        super();
        this.repository = repository;
    }

    public Group save(Group group) {
        return repository.save(group);
    }
    
    public Group getById(int id) {
        return repository.getById(id);
    }

    public Group getByName(String name) {
        Group group = repository.findByName(name);
        if (group == null) {
            group = repository.save(new Group(name));
        }
        return group;
    }
}
