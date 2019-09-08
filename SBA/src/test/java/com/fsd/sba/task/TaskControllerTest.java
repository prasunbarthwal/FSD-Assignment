package com.fsd.sba.task;



import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fsd.sba.FsdSbaApplication;
import com.fsd.sba.dto.ProjectDTO;
import com.fsd.sba.dto.TaskDto;
import com.fsd.sba.model.Task;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FsdSbaApplication.class)
@SpringBootTest
public class TaskControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }
/*
    @RequestMapping(value = "/endTask/{taskId}", method = RequestMethod.PUT)
    public ResponseEntity endTask(@PathVariable("taskId") Long id, @RequestBody TaskDto taskDto) ;

    @RequestMapping(value = "/updateTask", method = RequestMethod.PUT)
    public ResponseEntity updateTask(@RequestBody TaskDto taskDto);

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public ResponseEntity<Task> addTask(@RequestBody TaskDto taskDto);

    @RequestMapping(value = "/task/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<TaskDto> getTask(@PathVariable("taskId") Long id);

    @RequestMapping(value = "/tasks/{projectId}", method = RequestMethod.GET)
    public ResponseEntity<List<TaskDto>> getAllTasks(@PathVariable("projectId") Long projectId);*/

    @Test
    public void verifyEndTask() throws Exception {
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
        mockMvc.perform(MockMvcRequestBuilders.put("/fsd/updateProject")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(taskDto))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    public void verifyAllTaskList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fsd/tasks/1").accept(MediaType.APPLICATION_JSON))
                // .andExpect(jsonPath("$", hasSize(9)))
                .andDo(print())

                .andExpect(status().is(200));


    }

    @Test
    public void verifyGetTask() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fsd/task/1").accept(MediaType.APPLICATION_JSON))
                // .andExpect(jsonPath("$", hasSize(9)))
                .andExpect(jsonPath("$.taskId").exists())
                .andExpect(jsonPath("$.projectId").exists())
                .andExpect(jsonPath("$.projectName").exists())


                .andDo(print())
                .andExpect(status().is(200));


    }
    @Test
    public void verifySaveProject() throws Exception {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now();
        mockMvc.perform(MockMvcRequestBuilders.post("/fsd/project")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"projectName\" : \"Project test\" , \"userId\" : 1,\"priority\" : 15}")
                .accept(MediaType.APPLICATION_JSON))
                // .andExpect(jsonPath("$.projectId").exists())
                //.andExpect(jsonPath("$.projectName").exists())
                //  .andExpect(jsonPath("$.text").value("New ToDo Sample"))
                //.andExpect(jsonPath("$.completed").value(false))*//*
                .andDo(print())
                .andExpect(status().isCreated())
        ;
    }

    @Test
    public void verifyUpdateProject() throws Exception {
        ProjectDTO projectDTO = new ProjectDTO(Long.valueOf(1), "Test Project", "Test Manager", Long.valueOf(1), 1, 3, 2, LocalDate.now(), LocalDate.now());

        mockMvc.perform(MockMvcRequestBuilders.put("/fsd/updateProject")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(projectDTO))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

   /* @Test
    public void verifyProjectById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fsd/project/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.projectId").value(3))
                .andExpect(jsonPath("$.projectName").exists())
                .andExpect(jsonPath("$.userId").exists())
                .andExpect(jsonPath("$.priority").exists())
                .andDo(print());
    }*/

   /* @Test
    public void verifySaveProject() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/fsd/project")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\" : \"First\", \"lastName\" : \"last\" , \"empId\" : 15}")
                .accept(MediaType.APPLICATION_JSON))
                *//*.andExpect(jsonPath("$.taskId").exists())
                .andExpect(jsonPath("$.text").exists())
                .andExpect(jsonPath("$.completed").exists())
                .andExpect(jsonPath("$.text").value("New ToDo Sample"))
                .andExpect(jsonPath("$.completed").value(false))*//*
                .andDo(print())
                .andExpect(status().isCreated())
        ;
    }

    @Test
    public void verifyUpdateUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/fsd/updateUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userId\": 1, \"firstName\" : \"First name update\", \"lastName\" : \"last name update\" , \"empId\" : 3 }")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200));
    }*/
}
