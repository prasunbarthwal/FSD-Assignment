package com.fsd.sba.controller.impl;

import com.fsd.sba.controller.UserController;
import com.fsd.sba.dto.UserDTO;
import com.fsd.sba.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/fsd")
@Slf4j
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    /*@RequestMapping(value = "/delUser/{taskId}", method = RequestMethod.PUT)
    public ResponseEntity delUser(@PathVariable("taskId") Long taskId, @RequestBody UserDTO userDTO)
    {
        return null;
    }*/

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/user/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUser(@PathVariable("taskId") Long id) {
        UserDTO user = userService.findUser(id);
        return ResponseEntity.ok().body(user);

    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }


}
