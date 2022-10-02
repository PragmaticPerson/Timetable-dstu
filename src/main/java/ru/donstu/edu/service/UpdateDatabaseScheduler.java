package ru.donstu.edu.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import ru.donstu.edu.models.Group;

@Service
@PropertySource("classpath:cron.properties")
public class UpdateDatabaseScheduler {

    private UpdateDatabaseService updateService;
    private GroupService groupService;

    @Autowired
    public UpdateDatabaseScheduler(UpdateDatabaseService updateService, GroupService groupService) {
        super();
        this.updateService = updateService;
        this.groupService = groupService;
    }

    @Scheduled(cron = "${cron}")
    public void updateInformation() throws IOException {
        List<Group> groups = groupService.findAll();
        if (groups.isEmpty()) {
            updateService.updateGroups();
            groups = groupService.findAll();
        }

        for (Group g : groups) {
            updateService.updateTimetable(g.getId());
        }
    }
}
