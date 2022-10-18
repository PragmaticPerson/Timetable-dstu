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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + audienceId;
        result = prime * result + ((audienceNumber == null) ? 0 : audienceNumber.hashCode());
        result = prime * result + ((end == null) ? 0 : end.hashCode());
        result = prime * result + ((start == null) ? 0 : start.hashCode());
        result = prime * result + ((subject == null) ? 0 : subject.hashCode());
        result = prime * result + teacherId;
        result = prime * result + ((teacherName == null) ? 0 : teacherName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TimetableElement other = (TimetableElement) obj;
        if (audienceId != other.audienceId)
            return false;
        if (audienceNumber == null) {
            if (other.audienceNumber != null)
                return false;
        } else if (!audienceNumber.equals(other.audienceNumber))
            return false;
        if (end == null) {
            if (other.end != null)
                return false;
        } else if (!end.equals(other.end))
            return false;
        if (start == null) {
            if (other.start != null)
                return false;
        } else if (!start.equals(other.start))
            return false;
        if (subject == null) {
            if (other.subject != null)
                return false;
        } else if (!subject.equals(other.subject))
            return false;
        if (teacherId != other.teacherId)
            return false;
        if (teacherName == null) {
            if (other.teacherName != null)
                return false;
        } else if (!teacherName.equals(other.teacherName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TimetableElement [subject=" + subject + ", teacherId=" + teacherId + ", teacherName=" + teacherName
                + ", audienceId=" + audienceId + ", audienceNumber=" + audienceNumber + ", start=" + start + ", end="
                + end + "]";
    }

}
