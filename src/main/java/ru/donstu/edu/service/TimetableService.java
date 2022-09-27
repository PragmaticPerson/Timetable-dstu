package ru.donstu.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.donstu.edu.dao.TimetableJpaRepository;
import ru.donstu.edu.models.Group;
import ru.donstu.edu.models.Timetable;
import ru.donstu.edu.models.TimetableResponce;

@Service
public class TimetableService {

    private TimetableJpaRepository repository;

    @Autowired
    public TimetableService(TimetableJpaRepository repository) {
        super();
        this.repository = repository;
    }

    public List<TimetableResponce> getTimetableForGroup(int groupId) {
        var timetables = repository.findByGroupOrderByDateAscNumber(new Group(groupId, ""));
        List<TimetableResponce> responces = new ArrayList<>();

        Timetable last = null;
        var responce = new TimetableResponce();
        for (var t : timetables) {
            if (last != null) {
                if (last.getDate().equals(t.getDate())) {
                    responce.addLesson(t.makeElement());
                } else {
                    responces.add(responce);
                    responce = new TimetableResponce();
                    fillResponce(responce, t);
                }
            } else {
                fillResponce(responce, t);
            }

            last = t;
        }
        responces.add(responce);

        return responces;
    }

    private void fillResponce(TimetableResponce responce, Timetable t) {
        responce.setDate(t.getDate());
        responce.setDay(t.getDay());
        responce.setGroupId(t.getGroup().getId());
        responce.setGroupName(t.getGroup().getName());
        responce.addLesson(t.makeElement());
    }
}