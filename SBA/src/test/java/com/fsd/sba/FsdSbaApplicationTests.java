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
    static class BookServiceImplTestContextConfiguration {

        @Bean
        public TaskService taskService() {
            return new TaskServiceImpl();
        }


    }

    @Autowired
    TaskRepository taskRepository;

    @Test
    public void whenFindById_thenReturnTask() {
        // given
        Task task = new Task();
        //task.setId(Long.getLong("3"));
        task.setTask("TestTask");
        task.setPriority(10);

        task = taskRepository.save(task);

        // when
        Task found = taskRepository.findById(task.getId()).get();

        assertNotNull(found);

        // then
        assertThat(found.getPriority())
                .isEqualTo(task.getPriority());
        assertThat(found.getTask()).isEqualTo(task.getTask());
    }

    @Test
    public void saveTaskTest() {
        // given
        Task task = new Task();
        //task.setId(Long.getLong("3"));
        task.setTask("TestTask");
        task.setPriority(10);

        task = taskRepository.save(task);

        // when
        Task found = taskRepository.findById(task.getId()).get();

        assertNotNull(found);


    }

}
*/
