package com.fsd.sba.user;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fsd.sba.dao.UserRepository;
import com.fsd.sba.dto.UserDTO;
import com.fsd.sba.model.Project;
import com.fsd.sba.model.User;
import com.fsd.sba.service.UserService;
import com.fsd.sba.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    private Long userId;

    private String lastName;

    private String firstName;

    private Integer empId;

    @Test
    public void testGetAllToDo() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User());
        userList.add(new User());
        userList.add(new User());
        when(userRepository.findAll()).thenReturn(userList);

        List<UserDTO> result = userService.findAll();
        assertEquals(3, result.size());
    }

    @Test
    public void testGetUserById() {
        User user = new User(Long.valueOf(1), "Last Name", "First Name", 1,null);
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
        User saved = new User(Long.valueOf(2), "Last Name", "First Name", 1,null);
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
        User userExisting = new User(Long.valueOf(1), "Last Name", "First Name", 1, null);
        when(userRepository.getOne(1L)).thenReturn(userExisting);
        User user = User.builder()
                .userId(Long.valueOf(1))
                .empId(1)
                .firstName("First Name")
                .lastName("Last Name")
               // .projectId(null)
                .build();
        User saved = new User(Long.valueOf(1), "Last Name Changed", "First Name", 2,null);
        when(userRepository.save(user)).thenReturn(saved);
        User result = userService.updateUser(userDTO);
        assertEquals(Long.valueOf(1), result.getUserId());
        assertEquals("First Name", result.getFirstName());
        assertEquals("Last Name Changed", result.getLastName());

        assertEquals(Integer.valueOf(2), result.getEmpId());
    }

}
