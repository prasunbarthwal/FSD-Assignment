/*
package com.fsd.sba;

import com.fsd.sba.service.TaskService;
import com.fsd.sba.service.impl.TaskServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = FsdSbaApplication.class)
@Transactional
//@DataJpaTest

public class FsdSbaApplicationTests {

    @Test
    public void contextLoads() {
    }

    @TestConfiguration
    static class ServiceImplTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }


    }

    @Autowired
    TaskRepository taskRepository;

    @Test
    public void whenFindById_thenReturnTask() {
        // given
        User task = new User();
        //task.setId(Long.getLong("3"));
        task.setTask("TestTask");
        task.setPriority(10);

        task = taskRepository.save(task);

        // when
        User found = taskRepository.findById(task.getId()).get();

        assertNotNull(found);

        // then
        assertThat(found.getPriority())
                .isEqualTo(task.getPriority());
        assertThat(found.getTask()).isEqualTo(task.getTask());
    }

    @Test
    public void saveTaskTest() {
        // given
        User task = new User();
        //task.setId(Long.getLong("3"));
        task.setTask("TestTask");
        task.setPriority(10);

        task = taskRepository.save(task);

        // when
        User found = taskRepository.findById(task.getId()).get();

        assertNotNull(found);


    }

}
*/
