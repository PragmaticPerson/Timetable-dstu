package ru.donstu.edu.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ru.donstu.edu.models.TimetableResponce;
import ru.donstu.edu.service.TimetableService;
import ru.donstu.edu.service.UpdateDatabaseScheduler;

@RestController
public class AdminRestController {
    private UpdateDatabaseScheduler updateService;
    private TimetableService timetableService;

    @Autowired
    public AdminRestController(UpdateDatabaseScheduler updateService, TimetableService timetableService) {
        super();
        this.updateService = updateService;
        this.timetableService = timetableService;
    }

    @GetMapping(path = "/admin/update")
    @ResponseStatus(code = HttpStatus.OK)
    public void updateAllTimetable() throws IOException {
        updateService.updateInformation();
    }

    @GetMapping(path = "/timetable/{group}")
    public List<TimetableResponce> getTimetable(@PathVariable("group") int id) {
        return timetableService.getTimetableForGroup(id);
    }

    @GetMapping(path = "/timetable/audience/{audience}")
    public List<TimetableResponce> getTimetableGForAudience(@PathVariable("audience") int id) {
        return timetableService.getTimetableForAudience(id);
    }
}
