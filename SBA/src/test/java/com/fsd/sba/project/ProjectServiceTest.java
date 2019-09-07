package com.fsd.sba.project;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fsd.sba.dao.ProjectRepository;
import com.fsd.sba.dao.UserRepository;
import com.fsd.sba.dto.ProjectDTO;
import com.fsd.sba.dto.UserDTO;
import com.fsd.sba.model.Project;
import com.fsd.sba.model.User;
import com.fsd.sba.service.UserService;
import com.fsd.sba.service.impl.ProjectServiceImpl;
import com.fsd.sba.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ProjectServiceImpl projectService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    private Long projectId;

    private String projectName;

    private String manager;

    private Long userId;

    private Integer priority;

    private Integer totalTask;

    private Integer completedTask;

    private LocalDate startDate;

    private LocalDate endDate;

    @Test
    public void testGetAllProject() {
        List<Project> projectList = new ArrayList<Project>();

        projectList.add(new Project());
        projectList.add(new Project());
        projectList.add(new Project());
        when(projectRepository.findAll()).thenReturn(projectList);

        List<ProjectDTO> result = projectService.findAll();
        assertEquals(3, result.size());
    }

    @Test
    public void testGetProjectById() {
        Project project = new Project(Long.valueOf(1), "Test Project", LocalDate.now(), LocalDate.now(), 1);
        when(projectRepository.getOne(1L)).thenReturn(project);
        ProjectDTO result = projectService.findProject((Long.valueOf(1)));
        assertEquals(Long.valueOf(1), result.getProjectId());
        assertEquals("Test Project", result.getProjectName());
        assertEquals(LocalDate.now(), result.getStartDate());
        assertEquals(LocalDate.now(), result.getEndDate());

        assertEquals(Integer.valueOf(1), result.getPriority());
    }

    @Test
    public void saveProject()

    {
        UserDTO userDTO = new UserDTO(Long.valueOf(1), "Last Name", "First Name", 1);
        ProjectDTO projectDTO = new ProjectDTO(Long.valueOf(1), "Test Project", "Test Manager", Long.valueOf(1), 1, 3, 2, LocalDate.now(), LocalDate.now());
        //  User user = new User(Long.valueOf(1),"Last Name","First Name",1,new Project());
        Project toSave = Project.builder()
                //.id(Long.valueOf(1))
                .priority(1)
                .startDate(LocalDate.now())
                .endDate(LocalDate.now())
                .projectName("Test Project")
                .build();

        Project saved = new Project(Long.valueOf(1), "Test Project", LocalDate.now(), LocalDate.now(), 1);
        when(projectRepository.save(toSave)).thenReturn(saved);
        User user = new User(Long.valueOf(1), "Last Name", "First Name", 1,Long.valueOf(1),Long.valueOf(1));
        when(userRepository.getOne(1L)).thenReturn(user);

        Project result = projectService.saveProject(projectDTO);
        assertEquals(Long.valueOf(1), result.getId());
        assertEquals("Test Project", result.getProjectName());
        assertEquals(Integer.valueOf(1), result.getPriority());
        assertEquals(LocalDate.now(), result.getStartDate());
        assertEquals(LocalDate.now(), result.getEndDate());

    }


 /*   @Test
    public void saveProject {
        UserDTO userDTO = new UserDTO(Long.valueOf(1), "Last Name", "First Name", 1);
        ProjectDTO projectDTO = new ProjectDTO(Long.valueOf(1),"Test Project","Test Manager",Long.valueOf(1),1,LocalDate.now(),LocalDate.now());
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
