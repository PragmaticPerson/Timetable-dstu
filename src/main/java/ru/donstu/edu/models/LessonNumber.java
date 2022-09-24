package ru.donstu.edu.models;

public enum LessonNumber {
    FIRST("8:30", "10:00"), SECOND("10:15", "11:50"), THIRD("12:00", "13:35"), FOURTH("14:15", "15:50"),
    FIFTH("16:00", "17:35"), SIX("17:45", "19:20"), SEVENTH("19:30", "21:05");

    private String start;
    private String end;

    private LessonNumber(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
}
