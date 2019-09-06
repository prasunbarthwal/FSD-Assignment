package com.fsd.sba.controller;

import com.fsd.sba.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface UserController {

    /*@RequestMapping(value = "/delUser/{taskId}", method = RequestMethod.PUT)
    public ResponseEntity delUser(@PathVariable("taskId") Long taskId, @RequestBody UserDTO userDTO) ;
*/
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestBody UserDTO userDTO) ;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) ;

    @RequestMapping(value = "/user/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUser(@PathVariable("taskId") Long id) ;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity <List<UserDTO>> getAllUsers() ;

}
