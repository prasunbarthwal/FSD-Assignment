package com.fsd.sba.controller.impl;

import com.fsd.sba.controller.ProjectController;
import com.fsd.sba.dto.ProjectDTO;
import com.fsd.sba.dto.UserDTO;
import com.fsd.sba.model.Project;
import com.fsd.sba.service.ProjectService;
import com.fsd.sba.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "/fsd")
@Slf4j
public class ProjectControllerImpl implements ProjectController {

    @Autowired
    ProjectService projectService;

    @Override
    public ResponseEntity updateProject(ProjectDTO projectDto) {
        projectService.updateProject(projectDto);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }


    @RequestMapping(value = "/project", method = RequestMethod.POST)

    public ResponseEntity<ProjectDTO> addProject(ProjectDTO projectDTO) {
        projectService.saveProject(projectDTO);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);    }

    @Override
    public ResponseEntity<UserDTO> getProject(Long id) {
        return null;
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)

    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<ProjectDTO> projects = projectService.findAll();
        return ResponseEntity.ok().body(projects);    }
}
