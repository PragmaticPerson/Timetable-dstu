package ru.donstu.edu.service;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

import ru.donstu.edu.models.Audience;
import ru.donstu.edu.models.Group;
import ru.donstu.edu.models.LessonNumber;
import ru.donstu.edu.models.Subject;
import ru.donstu.edu.models.Teacher;
import ru.donstu.edu.models.Timetable;
import ru.donstu.edu.models.Weekdays;

@Service
public class UpdateDatabaseService {

    private DataReceiver receiver;
    private AudienceService audienceService;
    private SubjectService subjectService;
    private TeacherService teacherService;
    private GroupService groupService;
    private TimetableService timetableService;

    @Autowired
    public UpdateDatabaseService(DataReceiver receiver, AudienceService audienceService, SubjectService subjectService,
            TeacherService teacherService, GroupService groupService, TimetableService timetableService) {
        super();
        this.receiver = receiver;
        this.audienceService = audienceService;
        this.subjectService = subjectService;
        this.teacherService = teacherService;
        this.groupService = groupService;
        this.timetableService = timetableService;
    }

    public void updateGroups() throws IOException {
        JsonNode node = receiver.getGroups();

        node = node.get("data").get("groups");

        node.forEach(g -> {
            int id = g.get("groupID").asInt();
            String name = g.get("groupName").textValue().trim();

            groupService.save(new Group(id, name));
        });
    }

    public void updateTimetable(int id) throws IOException {
        timetableService.deleteForGroup(id);
        Group group = groupService.getById(id);

        LocalDate thisWeek = LocalDate.now().with(DayOfWeek.MONDAY);
        LocalDate nextWeek = thisWeek.plusDays(7);

        for (LocalDate week : Arrays.asList(thisWeek, nextWeek)) {
            JsonNode node = receiver.getTimetable(group, week);

            node = node.get("data").get("rasp");

            node.forEach(t -> {
                Timetable timetable = parceJson(t);
                timetable.setGroup(group);

                timetableService.save(timetable);
            });
        }
    }

    private Timetable parceJson(JsonNode t) {
        Subject subject = subjectService.getByName(t.get("дисциплина").textValue().trim());
        Teacher teacher = teacherService.getByName(t.get("преподаватель").textValue().trim());
        Audience audience = audienceService.getByName(t.get("аудитория").textValue().trim());
        Timetable timetable = new Timetable();

        timetable.setAudience(audience);
        timetable.setTeacher(teacher);
        timetable.setSubject(subject);
        timetable.setDate(LocalDate.parse(t.get("дата").textValue().split("T")[0]));
        timetable.setDay(Weekdays.findByName(t.get("день_недели").textValue()));
        timetable.setNumber(LessonNumber.findByStart(t.get("начало").textValue()));

        return timetable;
    }
}
