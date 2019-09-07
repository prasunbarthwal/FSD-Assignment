package com.fsd.sba.controller;

import com.fsd.sba.dto.ProjectDTO;
import com.fsd.sba.dto.UserDTO;
import com.fsd.sba.model.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface ProjectController {

    @RequestMapping(value = "/updateProject", method = RequestMethod.PUT)
    public ResponseEntity updateProject(@RequestBody ProjectDTO projectDTO) ;

    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public ResponseEntity<ProjectDTO> addProject(@RequestBody ProjectDTO projectDTO ) ;

   /* @RequestMapping(value = "/project/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getProject(@PathVariable("taskId") Long id) ;
*/
    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public ResponseEntity <List<ProjectDTO>> getAllProjects() ;
}
