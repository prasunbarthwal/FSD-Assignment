package com.fsd.sba.project;


import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fsd.sba.FsdSbaApplication;
import com.fsd.sba.dto.ProjectDTO;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FsdSbaApplication.class)
@SpringBootTest
public class ProjectControllerTest {

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
    public void verifyAllProjectList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fsd/projects").accept(MediaType.APPLICATION_JSON))
                // .andExpect(jsonPath("$", hasSize(9)))
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
