package ru.donstu.edu.service;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

import ru.donstu.edu.dao.GroupJpaRepository;
import ru.donstu.edu.dao.TimetableJpaRepository;
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
    private GroupJpaRepository groupRepository;
    private TimetableJpaRepository timetableRepository;

    @Autowired
    public UpdateDatabaseService(DataReceiver receiver, GroupJpaRepository groupRepository,
            TimetableJpaRepository timetableRepository) {
        super();
        this.receiver = receiver;
        this.groupRepository = groupRepository;
        this.timetableRepository = timetableRepository;
    }

    public void updateGroups() throws IOException {
        JsonNode node = receiver.getGroups();

        node = node.get("data").get("groups");

        node.forEach(g -> {
            String name = g.get("groupName").textValue().trim();
            int id = g.get("groupID").asInt();

            groupRepository.save(new Group(id, name));
        });
    }

    public void updateTimetable() throws IOException {
        LocalDate thisWeek = LocalDate.now().with(DayOfWeek.MONDAY);
        LocalDate nextWeek = thisWeek.plusDays(7);

        Group group = groupRepository.getById(44394);
        
        JsonNode node = receiver.getTimetable(group, thisWeek);

        node = node.get("data").get("rasp");

        node.forEach(t -> {
            Subject subject = new Subject(t.get("дисциплина").textValue().trim());

            Teacher teacher = new Teacher(t.get("преподаватель").textValue().trim(),
                    t.get("должность").textValue().trim());

            Audience audience = new Audience(t.get("аудитория").textValue().trim());

            Timetable timetable = new Timetable();

            timetable.setAudience(audience);
            timetable.setTeacher(teacher);
            timetable.setSubject(subject);
            timetable.setGroup(group);
            timetable.setDate(LocalDate.parse(t.get("дата").textValue().split("T")[0]));
            timetable.setDay(Weekdays.findByName(t.get("день_недели").textValue()));
            timetable.setNumber(LessonNumber.findByStart(t.get("начало").textValue()));

            timetableRepository.save(timetable);
        });
    }
}
