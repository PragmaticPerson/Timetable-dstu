package ru.donstu.edu.models;

import java.util.Arrays;

public enum LessonNumber {
    FIRST(1, "8:30", "10:00"), SECOND(2, "10:15", "11:50"), THIRD(3, "12:00", "13:35"), FOURTH(4, "14:15", "15:50"),
    FIFTH(5, "16:00", "17:35"), SIX(6, "17:45", "19:20"), SEVENTH(7, "19:30", "21:05");

    private int id;
    private String start;
    private String end;

    private LessonNumber(int id, String start, String end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public static LessonNumber findByStart(String start) {
        return Arrays.asList(LessonNumber.values()).stream().filter(n -> n.getStart().equals(start)).findFirst()
                .orElse(LessonNumber.FIRST);
    }

    public static LessonNumber findById(int id) {
        return Arrays.asList(LessonNumber.values()).stream().filter(n -> n.getId() == id).findFirst()
                .orElse(LessonNumber.FIRST);
    }

    public int getId() {
        return id;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
}