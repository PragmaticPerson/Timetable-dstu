package ru.donstu.edu.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import ru.donstu.edu.models.Group;

@Service
@PropertySource("classpath:cron.properties")
public class UpdateDatabaseScheduler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
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
        logger.info("Start updating timetable for groups.");
        List<Group> groups = groupService.findAll();
        if (groups.isEmpty()) {
            logger.info("No groups was found. Updating groups in database.");
            updateService.updateGroups();
            groups = groupService.findAll();
        }

        for (Group g : groups) {
            updateService.updateTimetable(g.getId());
        }
    }
}
