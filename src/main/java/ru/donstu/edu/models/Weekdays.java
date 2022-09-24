package ru.donstu.edu.models;

public enum Weekdays {
    MONDAY("Понедельник"),
    TUESDAY("Вторник"),
    WEDNESDAY("Среда"),
    THURSDAY("Четверг"),
    FRIDAY("Пятница"),
    SATURDAY("Суббота"),
    SUNDAY("Воскресенье");
    
    private String name;

    private Weekdays(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
}
