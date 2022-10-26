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

import ru.donstu.edu.models.Audience;

@DatabaseSetup("classpath:data.xml")
@RunWith(SpringRunner.class)
@DataJpaTest
@TestExecutionListeners({ 
        TransactionalTestExecutionListener.class, 
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
class AudienceJpaRepositoryTest {

    private AudienceJpaRepository repository;

    @Autowired
    public AudienceJpaRepositoryTest(AudienceJpaRepository repository) {
        super();
        this.repository = repository;
    }

    @Test
    void findAudienceByNameTest_audienceEntityExpected() {
        Audience expected = new Audience("1-101");
        expected.setId(1);

        Audience actual = repository.findByName("1-101");

        assertEquals(expected, actual);
    }

    @Test
    void findAudienceByNameTest_nullEntityExpected() {
        assertNull(repository.findByName("1-103"));
    }
}
