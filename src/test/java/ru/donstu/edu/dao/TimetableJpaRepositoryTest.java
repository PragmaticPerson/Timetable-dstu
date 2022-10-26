package ru.donstu.edu.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;

import ru.donstu.edu.models.Audience;
import ru.donstu.edu.models.Group;
import ru.donstu.edu.models.LessonNumber;
import ru.donstu.edu.models.Subject;
import ru.donstu.edu.models.Teacher;
import ru.donstu.edu.models.Timetable;
import ru.donstu.edu.models.Weekdays;

@DatabaseSetup("classpath:data.xml")
@RunWith(SpringRunner.class)
@DataJpaTest
@TestExecutionListeners({ TransactionalTestExecutionListener.class, DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
class TimetableJpaRepositoryTest {

    private TimetableJpaRepository repository;

    private static Timetable timetable1;
    private static Timetable timetable2;
    private static Timetable timetable3;
    private static Timetable timetable4;

    @Autowired
    public TimetableJpaRepositoryTest(TimetableJpaRepository repository) {
        super();
        this.repository = repository;
    }

    @BeforeAll
    static void prepareAllData() {
        Group group1 = new Group(1, "Group one");
        Group group2 = new Group(2, "Group two");

        Teacher teacher1 = new Teacher(1, "Teacher One");
        Teacher teacher2 = new Teacher(2, "Teacher Two");

        Subject subject1 = new Subject(1, "Subject one");
        Subject subject2 = new Subject(2, "Subject two");

        Audience audience1 = new Audience(1, "1-101");
        Audience audience2 = new Audience(2, "1-102");

        timetable1 = new Timetable(1, group1, audience1, teacher1, subject1, LocalDate.parse("2022-10-03"),
                Weekdays.MONDAY, LessonNumber.FIRST);
        timetable2 = new Timetable(2, group1, audience2, teacher2, subject2, LocalDate.parse("2022-10-05"),
                Weekdays.WEDNESDAY, LessonNumber.SIX);
        timetable3 = new Timetable(3, group2, audience2, teacher1, subject2, LocalDate.parse("2022-10-06"),
                Weekdays.THURSDAY, LessonNumber.SEVENTH);
        timetable4 = new Timetable(4, group2, audience1, teacher2, subject1, LocalDate.parse("2022-10-02"),
                Weekdays.TUESDAY, LessonNumber.THIRD);
    }

    @Test
    void getTimetableForGroup_timetableListyExpected() {
        List<Timetable> expected = Arrays.asList(timetable4, timetable3);

        List<Timetable> actual = repository.findByGroupOrderByDateAscNumber(new Group(2, ""));

        assertEquals(expected, actual);
    }

    @Test
    void getTimetableForGroup_emptyListExpected() {
        List<Timetable> expected = Arrays.asList();

        List<Timetable> actual = repository.findByGroupOrderByDateAscNumber(new Group(3, ""));

        assertEquals(expected, actual);
    }

    @Test
    void getTimetableForAudience_timetableListExpected() {
        List<Timetable> expected = Arrays.asList(timetable2, timetable3);

        List<Timetable> actual = repository.findByAudienceOrderByDateAscNumber(new Audience(2, ""));

        assertEquals(expected, actual);
    }

    @Test
    void getTimetableForAudience_emptyListExpected() {
        List<Timetable> expected = Arrays.asList();

        List<Timetable> actual = repository.findByGroupOrderByDateAscNumber(new Group(3, ""));

        assertEquals(expected, actual);
    }

    @Test
    @ExpectedDatabase(table = "timetable", value = "classpath:dbunit/expectedTimetableWhenDelete.xml")
    void deleteTimetableForGroup_expectedSuccess() {
        repository.deleteAllByGroup(1);
    }
}
