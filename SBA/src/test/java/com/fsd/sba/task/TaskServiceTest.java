package com.fsd.sba.task;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fsd.sba.dao.ParentTaskRepository;
import com.fsd.sba.dao.ProjectRepository;
import com.fsd.sba.dao.TaskRepository;
import com.fsd.sba.dao.UserRepository;
import com.fsd.sba.dto.ProjectDTO;
import com.fsd.sba.dto.TaskDto;
import com.fsd.sba.dto.UserDTO;
import com.fsd.sba.model.ParentTask;
import com.fsd.sba.model.Project;
import com.fsd.sba.model.Task;
import com.fsd.sba.model.User;
import com.fsd.sba.service.UserService;
import com.fsd.sba.service.impl.TaskServiceImpl;
import com.fsd.sba.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class TaskServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private ParentTaskRepository parentTaskRepository;

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void testGetAllTaskByProjectId() {
        Task taskOne = new Task(Long.valueOf(1),Long.valueOf(1),Long.valueOf(1),"task One",null, LocalDate.now(),LocalDate.now(),1);
        Task taskTwo = new Task(Long.valueOf(2),Long.valueOf(1),Long.valueOf(1),"task two ",null, LocalDate.now(),LocalDate.now(),2);
        Task taskThree = new Task(Long.valueOf(3),Long.valueOf(1),Long.valueOf(1),"task three","COMPLETED", LocalDate.now(),LocalDate.now(),3);

        List<Task> taskList = new ArrayList<>();

        taskList.add(taskOne);
        taskList.add(taskTwo);
        taskList.add(taskThree);
        when(taskRepository.findTaskByProjectId(Long.valueOf(1))).thenReturn(taskList);
        ParentTask parentTask = new ParentTask(Long.valueOf(1),"Parent Task");
        when(parentTaskRepository.getOne(Long.valueOf(1))).thenReturn(parentTask);
        /*when(userRepository.findByProjectId(Long.valueOf(1))).thenReturn(user);
        when(taskRepository.findTaskByProjectId(Long.valueOf(1))).thenReturn(null);
        when(taskRepository.findTaskByProjectIdAndStatus(Long.valueOf(1),"COMPLETED")).thenReturn(null);
*/
        List<TaskDto> result = taskService.findTaskByProject(Long.valueOf(1));
        assertEquals(3, result.size());
    }
/*
    @Test
    public void testGetUserById() {
        User user = new User(Long.valueOf(1), "Last Name", "First Name", 1,Long.valueOf(1),Long.valueOf(1));
        when(userRepository.getOne(1L)).thenReturn(user);
        UserDTO result = userService.findUser(Long.valueOf(1));
        assertEquals(Long.valueOf(1), result.getUserId());
        assertEquals("First Name", result.getFirstName());
        assertEquals("Last Name", result.getLastName());
        assertEquals(Integer.valueOf(1), result.getEmpId());
    }

    @Test
    public void saveUser() {
        UserDTO userDTO = new UserDTO(Long.valueOf(1), "Last Name", "First Name", 1);
        //  User user = new User(Long.valueOf(1),"Last Name","First Name",1,new Project());
        User user = User.builder()
                .empId(1)
                .firstName("First Name")
                .lastName("Last Name")
                .build();
        User saved = new User(Long.valueOf(2), "Last Name", "First Name", 1,Long.valueOf(1),Long.valueOf(1));
        when(userRepository.save(user)).thenReturn(saved);
        User result = userService.saveUser(userDTO);
        assertEquals(Long.valueOf(2), result.getUserId());
        assertEquals("First Name", result.getFirstName());
        assertEquals("Last Name", result.getLastName());

        assertEquals(Integer.valueOf(1), result.getEmpId());
    }

    @Test
    public void updateUser() {
        UserDTO userDTO = new UserDTO(Long.valueOf(1), "Last Name", "First Name", 1);
        //  User user = new User(Long.valueOf(1),"Last Name","First Name",1,new Project());
        User userExisting = new User(Long.valueOf(1), "Last Name", "First Name", 1, Long.valueOf(1),Long.valueOf(1));
        when(userRepository.getOne(1L)).thenReturn(userExisting);
        User user = User.builder()
                .userId(Long.valueOf(1))
                .empId(1)
                .firstName("First Name")
                .lastName("Last Name")
                .projectId(Long.valueOf(1))
                .taskId(Long.valueOf(1))
                .build();
        User saved = new User(Long.valueOf(1), "Last Name Changed", "First Name", 2,Long.valueOf(1),Long.valueOf(1));
        when(userRepository.save(user)).thenReturn(saved);
        User result = userService.updateUser(userDTO);
        assertEquals(Long.valueOf(1), result.getUserId());
        assertEquals("First Name", result.getFirstName());
        assertEquals("Last Name Changed", result.getLastName());

        assertEquals(Integer.valueOf(2), result.getEmpId());
    }*/

}
