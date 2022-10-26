package ru.donstu.edu.dao;

import static org.junit.jupiter.api.Assertions.*;

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

import ru.donstu.edu.models.Teacher;

@DatabaseSetup("classpath:data.xml")
@RunWith(SpringRunner.class)
@DataJpaTest
@TestExecutionListeners({ 
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
class TeacherJpaRepositoryTest {

    private TeacherJpaRepository repository;

    @Autowired
    public TeacherJpaRepositoryTest(TeacherJpaRepository repository) {
        super();
        this.repository = repository;
    }

    @Test
    void findTeacherByNameTest_teacherEntityExpected() {
        Teacher expected = new Teacher("Teacher One");
        expected.setId(1);

        Teacher actual = repository.findByName("Teacher One");

        assertEquals(expected, actual);
    }

    @Test
    void findTeacherByNameTest_nullEntityExpected() {
        assertNull(repository.findByName("Teacher three"));
    }
}
