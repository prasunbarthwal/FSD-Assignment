package com.fsd.sba.task;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fsd.sba.dao.ParentTaskRepository;
import com.fsd.sba.dao.ProjectRepository;
import com.fsd.sba.dao.TaskRepository;
import com.fsd.sba.dao.UserRepository;
import com.fsd.sba.dto.ParentTaskDto;
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
import org.omg.CORBA.INTERNAL;
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
    public void testfindTaskByProject() {
        Task taskOne = new Task(Long.valueOf(1), Long.valueOf(1), Long.valueOf(1), "task One", null, LocalDate.now(), LocalDate.now(), 1);
        Task taskTwo = new Task(Long.valueOf(2), Long.valueOf(1), Long.valueOf(1), "task two ", null, LocalDate.now(), LocalDate.now(), 2);
        Task taskThree = new Task(Long.valueOf(3), Long.valueOf(1), Long.valueOf(1), "task three", "COMPLETED", LocalDate.now(), LocalDate.now(), 3);

        List<Task> taskList = new ArrayList<>();

        taskList.add(taskOne);
        taskList.add(taskTwo);
        taskList.add(taskThree);
        when(taskRepository.findTaskByProjectId(Long.valueOf(1))).thenReturn(taskList);
        ParentTask parentTask = new ParentTask(Long.valueOf(1), "Parent Task");
        when(parentTaskRepository.getOne(Long.valueOf(1))).thenReturn(parentTask);
        /*when(userRepository.findByProjectId(Long.valueOf(1))).thenReturn(user);
        when(taskRepository.findTaskByProjectId(Long.valueOf(1))).thenReturn(null);
        when(taskRepository.findTaskByProjectIdAndStatus(Long.valueOf(1),"COMPLETED")).thenReturn(null);
*/
        List<TaskDto> result = taskService.findTaskByProject(Long.valueOf(1));
        assertEquals(3, result.size());
    }

    @Test
    public void testEndTaskById() {
        Task taskOne = new Task(Long.valueOf(1), Long.valueOf(1), Long.valueOf(1), "task One", null, LocalDate.now(), LocalDate.now(), 1);
        Task saved =   Task.builder()
                .id(Long.valueOf(1))
                .endDate(LocalDate.now())
                .startDate(LocalDate.now())
                .task("task")
                .priority(1)
                .status("COMPLETED")
                .projectId(Long.valueOf(1))
                .parentId(Long.valueOf(1))
                .build();
        when(taskRepository.getOne(1L)).thenReturn(taskOne);
        when(taskRepository.save(taskOne)).thenReturn(saved);
       Task result =  taskService.endTask(taskOne.getId());
        assertEquals("COMPLETED", result.getStatus());



    }

    @Test
    public void testGetTaskById() {
        Task taskOne = new Task(Long.valueOf(1), Long.valueOf(1), Long.valueOf(1), "task One", null, LocalDate.now(), LocalDate.now(), 1);
        ParentTask parentTask = new ParentTask(Long.valueOf(1), "Parent Task");
        when(parentTaskRepository.getOne(taskOne.getParentId())).thenReturn(parentTask);
        Project project = new Project(Long.valueOf(1), "Test Project", LocalDate.now(), LocalDate.now(), 1);
        when(projectRepository.getOne(taskOne.getProjectId())).thenReturn(project);


        when(taskRepository.getOne(1L)).thenReturn(taskOne);
        TaskDto result = taskService.findTask(Long.valueOf(1));

        assertEquals(Long.valueOf(1), result.getTaskId());
        assertEquals("task One", result.getTask());
        assertEquals(Integer.valueOf(1), result.getPriority());
        assertEquals(LocalDate.now(), result.getStartDate());
        assertEquals(LocalDate.now(), result.getEndDate());

    }

    @Test
    public void testFindAllParent() {

        List<ParentTask> parentTaskList = new ArrayList<>();

        parentTaskList.add(new ParentTask(Long.valueOf(1),"parent1"));
        parentTaskList.add(new ParentTask(Long.valueOf(2),"parent2"));
        when(parentTaskRepository.findAll()).thenReturn(parentTaskList);

      List<ParentTaskDto> result =   taskService.findAllParent();
        assertEquals(2, result.size());


    }

    @Test
    public void updateTask() {
        TaskDto taskDto = TaskDto.builder()
                .taskId(Long.valueOf(1))
                .userId(Long.valueOf(1)).userName("user")
                .task("task")
                .projectName("project")
                .projectId(Long.valueOf(1))
                .startDate(LocalDate.now())
                .endDate(LocalDate.now())
                .parentTask("parent")
                .parentTaskId(Long.valueOf(1))
                .isParent(false)
                .priority(1)
                .build();
        Task taskOne = new Task(Long.valueOf(1), Long.valueOf(1), Long.valueOf(1), "task One", null, LocalDate.now(), LocalDate.now(), 1);
        Task saved =   Task.builder()
                .id(Long.valueOf(1))
                .endDate(LocalDate.now())
                .startDate(LocalDate.now())
                .task("task")
                .priority(2)
                .status("UPDATED")
                .projectId(Long.valueOf(1))
                .parentId(Long.valueOf(1))
                .build();
        when(taskRepository.getOne(1L)).thenReturn(taskOne);
        when(taskRepository.save(taskOne)).thenReturn(saved);
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
        User userSaved = new User(Long.valueOf(1), "Last Name Changed", "First Name", 2,Long.valueOf(1),Long.valueOf(1));
        when(userRepository.save(user)).thenReturn(userSaved);


Task result = taskService.updateTask(taskDto);
        assertEquals(Long.valueOf(1), result.getId());
        assertEquals(Long.valueOf(1), result.getParentId());
        assertEquals(Long.valueOf(1), result.getProjectId());

        assertEquals("task", result.getTask());
        assertEquals(Integer.valueOf(2), result.getPriority());

        assertEquals(LocalDate.now(), result.getStartDate());
        assertEquals(LocalDate.now(), result.getEndDate());

    }
    @Test
    public void saveParentTask() {
        TaskDto taskDto = TaskDto.builder()
                .projectId(Long.valueOf(1))
                .task( "Parent Task")
                .isParent(true).build();
        ParentTask parentTask = new ParentTask(Long.valueOf(1), "Parent Task");
        when(parentTaskRepository.save(parentTask)).thenReturn(parentTask);
        Task result  = taskService.saveTask(taskDto);
        assertEquals(null, result);


    }
    @Test
    public void saveTask() {
        TaskDto taskDto = TaskDto.builder()
                //.taskId(Long.valueOf(1))
                .userId(Long.valueOf(1)).userName("user")
                .task("task")
                .projectName("project")
                .projectId(Long.valueOf(1))
                .startDate(LocalDate.now())
                .endDate(LocalDate.now())
                .parentTask("parent")
                .parentTaskId(Long.valueOf(1))
                .isParent(false)
                .priority(1)
                .build();
     Task task =   Task.builder().endDate(LocalDate.now())
                .startDate(LocalDate.now())
                .task("task")
                .priority(1)
                .projectId(Long.valueOf(1))
                .parentId(Long.valueOf(1))
                .build();
        Task saved =   Task.builder()
                .id(Long.valueOf(1))
                .endDate(LocalDate.now())
                .startDate(LocalDate.now())
                .task("task")
                .priority(1)
                .projectId(Long.valueOf(1))
                .parentId(Long.valueOf(1))
                .build();
/*
        TaskDto taskDtoParent = TaskDto.builder()
                .taskId(Long.valueOf(1))
                .userId(Long.valueOf(1))
                .projectName("project")
                .projectId(Long.valueOf(1))
                .startDate(LocalDate.now())
                .endDate(LocalDate.now())
                .parentTask("parent")
                .parentTaskId(Long.valueOf(1))
                .isParent(false)
                .priority(1)
                .build();*/
        //  User user = new User(Long.valueOf(1),"Last Name","First Name",1,new Project());

       // User saved = new User(Long.valueOf(2), "Last Name", "First Name", 1, Long.valueOf(1), Long.valueOf(1));
        when(taskRepository.save(task)).thenReturn(saved);
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
        User userSaved = new User(Long.valueOf(1), "Last Name Changed", "First Name", 2,Long.valueOf(1),Long.valueOf(1));
        when(userRepository.save(user)).thenReturn(userSaved);
        Task result = taskService.saveTask(taskDto);
        assertEquals(Long.valueOf(1), result.getId());
        assertEquals(Long.valueOf(1), result.getParentId());
        assertEquals(Long.valueOf(1), result.getProjectId());

        assertEquals("task", result.getTask());
        assertEquals(Integer.valueOf(1), result.getPriority());

        assertEquals(LocalDate.now(), result.getStartDate());
        assertEquals(LocalDate.now(), result.getEndDate());

    }
/*




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
