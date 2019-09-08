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
        log.debug("Inside updateUSer method");
        userService.updateUser(userDTO);
        log.debug(" updateUSer successfully completed");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        log.debug("Inside addUser method");

        userService.saveUser(userDTO);
        HttpHeaders headers = new HttpHeaders();
        log.debug(" addUser successfully completed");

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/user/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUser(@PathVariable("taskId") Long id) {
        log.debug("Inside getUser method");

        UserDTO user = userService.findUser(id);

        log.debug(" Found user with id :"+id);

        return ResponseEntity.ok().body(user);

    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        log.debug("Inside getAllUsers method");

        List<UserDTO> users = userService.findAll();
        log.debug(" Found  users list " );

        return ResponseEntity.ok().body(users);
    }


}
