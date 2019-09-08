package com.fsd.sba.service;

import com.fsd.sba.dto.ProjectDTO;
import com.fsd.sba.dto.UserDTO;
import com.fsd.sba.model.Project;
import com.fsd.sba.model.User;

import java.util.List;

public interface ProjectService {

    List<ProjectDTO> findAll();

    Project saveProject(ProjectDTO projectDTO);

    Project updateProject(ProjectDTO projectDTO);
}
