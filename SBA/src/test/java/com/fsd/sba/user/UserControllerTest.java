package com.fsd.sba.user;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fsd.sba.FsdSbaApplication;
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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FsdSbaApplication.class)
@SpringBootTest
public class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

  @Test
    public void verifyAllUserList() throws Exception {
      mockMvc.perform(MockMvcRequestBuilders.get("/fsd/users").accept(MediaType.APPLICATION_JSON))
             // .andExpect(jsonPath("$", hasSize(9)))
               .andDo(print())
              .andExpect(status().is(200));


  }

    @Test
    public void verifyUserById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fsd/user/3").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userId").value(3))
                .andExpect(jsonPath("$.firstName").exists())
                .andExpect(jsonPath("$.lastName").exists())
                .andExpect(jsonPath("$.empId").exists())
                .andDo(print());
    }

    @Test
    public void verifySaveUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/fsd/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\" : \"First\", \"lastName\" : \"last\" , \"empId\" : 15}")
                .accept(MediaType.APPLICATION_JSON))
                /*.andExpect(jsonPath("$.taskId").exists())
                .andExpect(jsonPath("$.text").exists())
                .andExpect(jsonPath("$.completed").exists())
                .andExpect(jsonPath("$.text").value("New ToDo Sample"))
                .andExpect(jsonPath("$.completed").value(false))*/
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
    }
}
