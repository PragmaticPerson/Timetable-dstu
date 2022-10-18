package ru.donstu.edu.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.donstu.edu.dao.GroupJpaRepository;
import ru.donstu.edu.models.Group;

@Service
public class GroupService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private GroupJpaRepository repository;

    @Autowired
    public GroupService(GroupJpaRepository repository) {
        super();
        this.repository = repository;
    }

    public List<Group> findAll() {
        return repository.findAll();
    }

    public Group save(Group group) {
        return repository.save(group);
    }

    public Group getById(int id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("No entity with id " + id));
    }

    public Group getByName(String name) {
        logger.debug("Getting group with name '{}'", name);

        Group group = repository.findByName(name);
        if (group == null) {
            logger.debug("No group with name '{}' exist. Creating such", name);
            group = save(new Group(name));
        }
        return group;
    }
}
