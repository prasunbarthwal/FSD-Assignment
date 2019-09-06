/*
package com.fsd.sba;

import com.fsd.sba.dao.UserRepository;
import com.fsd.sba.dto.UserDTO;
import com.fsd.sba.model.User;
import com.fsd.sba.service.UserService;
import com.fsd.sba.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
    UserRepository userRepository;

    @Test
    public void whenFindById_thenReturnUser() {
        // given
        User user = new User();
        user.setUserId(Long.getLong("999"));
        user.setFirstName("Test First Name");
        user.setLastName("Test Last Name");
        user.setEmpId(Integer.valueOf("999"));

      */
/*  UserDTO userDTO = new UserDTO();
        //userDTO.setUserId(Long.getLong("999"));
        userDTO.setFirstName("Test First Name");
        userDTO.setLastName("Test Last Name");
        userDTO.setEmpId(Integer.valueOf("999"));*//*


     //  User user  = new UserServiceImpl().saveUser(userDTO);
       // task = taskRepository.save(task);
           user = userRepository.save(user);
        // when


        Optional<User> found = userRepository.findById(user.getUserId());

        assertNotNull(found);

        // then
       */
/* assertThat(found.())
                .isEqualTo(task.getPriority());
        assertThat(found.getTask()).isEqualTo(task.getTask());*//*

    }
*/
/*
    @Test
    public void saveTaskTest() {
        // given
        User task = new User();
        //task.setTaskId(Long.getLong("3"));
        task.setTask("TestTask");
        task.setPriority(10);

        task = taskRepository.save(task);

        // when
        User found = taskRepository.findById(task.getTaskId()).get();

        assertNotNull(found);


    }*//*


}
*/
