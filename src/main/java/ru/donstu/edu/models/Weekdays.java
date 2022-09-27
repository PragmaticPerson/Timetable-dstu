package ru.donstu.edu.models;

import java.util.Arrays;

public enum Weekdays {
    MONDAY("Понедельник"), TUESDAY("Вторник"), WEDNESDAY("Среда"), THURSDAY("Четверг"), FRIDAY("Пятница"),
    SATURDAY("Суббота"), SUNDAY("Воскресенье");

    private String name;

    private Weekdays(String name) {
        this.name = name;
    }

    public static Weekdays findByName(String name) {
        return Arrays.asList(Weekdays.values()).stream().filter(n -> n.getName().equals(name)).findFirst()
                .orElse(Weekdays.MONDAY);
    }

    public String getName() {
        return name;
    }
}