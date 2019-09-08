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
        mockMvc.perform(MockMvcRequestBuilders.put("/fsd/endTask/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(taskDto))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());


    }
    @Test
    public void verifySaveTask() throws Exception {

        TaskDto taskDto = TaskDto.builder()
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
        mockMvc.perform(MockMvcRequestBuilders.post("/fsd/task")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(taskDto))
                .accept(MediaType.APPLICATION_JSON))
            //    .andExpect(jsonPath("$.id").exists())
              //  .andExpect(jsonPath("$.task").exists())
                //.andExpect(jsonPath("$.projectId").exists())
                .andDo(print())
                .andExpect(status().isCreated());

    }
    @Test
    public void verifyAllTaskList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fsd/tasks/1").accept(MediaType.APPLICATION_JSON))
                // .andExpect(jsonPath("$", hasSize(9)))
                .andDo(print())

                .andExpect(status().isOk());


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
    public void verifyAllParents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fsd/parents").accept(MediaType.APPLICATION_JSON))
                // .andExpect(jsonPath("$", hasSize(9))) updateTask
                 .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    public void verifyUpdateTask() throws Exception {

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
        mockMvc.perform(MockMvcRequestBuilders.put("/fsd/updateTask")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(taskDto))
                .accept(MediaType.APPLICATION_JSON))
                //    .andExpect(jsonPath("$.id").exists())
                //  .andExpect(jsonPath("$.task").exists())
                //.andExpect(jsonPath("$.projectId").exists())
                .andDo(print())
                .andExpect(status().isOk());

    }
}
