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

import ru.donstu.edu.models.Group;

@DatabaseSetup("classpath:data.xml")
@RunWith(SpringRunner.class)
@DataJpaTest
@TestExecutionListeners({ 
        TransactionalTestExecutionListener.class, 
        DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
class GroupJpaRepositoryTest {

    private GroupJpaRepository repository;

    @Autowired
    public GroupJpaRepositoryTest(GroupJpaRepository repository) {
        super();
        this.repository = repository;
    }

    @Test
    void findGroupByNameTest_groupEntityExpected() {
        Group expected = new Group("Group one");
        expected.setId(1);

        Group actual = repository.findByName("Group one");

        assertEquals(expected, actual);
    }

    @Test
    void findGroupByNameTest_nullEntityExpected() {
        assertNull(repository.findByName("Group three"));
    }

}
