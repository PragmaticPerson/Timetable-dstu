package ru.donstu.edu.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TimetableResponce {

    private int groupId;
    private String groupName;
    private Weekdays day;
    private LocalDate date;
    private List<TimetableElement> lessons;

    public TimetableResponce() {
        super();
        lessons = new ArrayList<>();
    }

    public TimetableResponce(int groupId, String groupName, Weekdays day, LocalDate date) {
        super();
        this.groupId = groupId;
        this.groupName = groupName;
        this.day = day;
        this.date = date;
        lessons = new ArrayList<>();
    }

    public TimetableResponce(int groupId, String groupName, Weekdays day, LocalDate date,
            List<TimetableElement> lessons) {
        super();
        this.groupId = groupId;
        this.groupName = groupName;
        this.day = day;
        this.date = date;
        this.lessons = lessons;
    }
    
    public void addLesson(TimetableElement element) {
        lessons.add(element);
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Weekdays getDay() {
        return day;
    }

    public void setDay(Weekdays day) {
        this.day = day;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<TimetableElement> getLessons() {
        return lessons;
    }

    public void setLessons(List<TimetableElement> lessons) {
        this.lessons = lessons;
    }

}
