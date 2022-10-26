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

import ru.donstu.edu.models.Subject;

@DatabaseSetup("classpath:data.xml")
@RunWith(SpringRunner.class)
@DataJpaTest
@TestExecutionListeners({ 
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
class SubjectJpaRepositoryTest {

    private SubjectJpaRepository repository;

    @Autowired
    public SubjectJpaRepositoryTest(SubjectJpaRepository repository) {
        super();
        this.repository = repository;
    }

    @Test
    void findSubjectByNameTest_subjectEntityExpected() {
        Subject expected = new Subject("Subject one");
        expected.setId(1);

        Subject actual = repository.findByName("Subject one");

        assertEquals(expected, actual);
    }

    @Test
    void findSubjectByNameTest_nullEntityExpected() {
        assertNull(repository.findByName("Subject three"));
    }
}
