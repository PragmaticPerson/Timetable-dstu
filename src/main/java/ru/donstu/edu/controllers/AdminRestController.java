package ru.donstu.edu.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ru.donstu.edu.dao.GroupJpaRepository;
import ru.donstu.edu.models.Group;
import ru.donstu.edu.models.TimetableResponce;
import ru.donstu.edu.service.TimetableService;
import ru.donstu.edu.service.UpdateDatabaseService;

@RestController
public class AdminRestController {
    private UpdateDatabaseService updateService;
    private GroupJpaRepository groupRepository;
    private TimetableService timetableService;

    @Autowired
    public AdminRestController(UpdateDatabaseService updateService, GroupJpaRepository groupRepository,
            TimetableService timetableService) {
        super();
        this.updateService = updateService;
        this.groupRepository = groupRepository;
        this.timetableService = timetableService;
    }

    @GetMapping(path = "/groups/update")
    public List<Group> updateGroups() throws IOException {
        updateService.updateGroups();
        return groupRepository.findAll();
    }

    @GetMapping(path = "/timetable/{group}/update")
    public List<TimetableResponce> updateTimetable(@PathVariable("group") int id) throws IOException {
        updateService.updateTimetable(id);
        return timetableService.getTimetableForGroup(id);
    }

    @GetMapping(path = "/timetable/{group}")
    public List<TimetableResponce> getTimetable(@PathVariable("group") int id) {
        return timetableService.getTimetableForGroup(id);
    }
}
