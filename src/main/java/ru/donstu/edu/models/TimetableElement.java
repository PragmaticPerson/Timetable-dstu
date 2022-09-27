package ru.donstu.edu.models;

public class TimetableElement {

    private String subject;
    private int teacherId;
    private String teacherName;
    private int audienceId;
    private String audienceNumber;
    private String start;
    private String end;

    public TimetableElement() {
        super();
    }

    public TimetableElement(String subject, int teacherId, String teacherName, int audienceId, String audienceNumber,
            String start, String end) {
        super();
        this.subject = subject;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.audienceId = audienceId;
        this.audienceNumber = audienceNumber;
        this.start = start;
        this.end = end;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getAudienceId() {
        return audienceId;
    }

    public void setAudienceId(int audienceId) {
        this.audienceId = audienceId;
    }

    public String getAudienceNumber() {
        return audienceNumber;
    }

    public void setAudienceNumber(String audienceNumber) {
        this.audienceNumber = audienceNumber;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

}
