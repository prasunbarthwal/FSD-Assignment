package com.fsd.sba.service.impl;

import com.fsd.sba.dao.ProjectRepository;
import com.fsd.sba.dao.UserRepository;
import com.fsd.sba.dto.ProjectDTO;
import com.fsd.sba.dto.UserDTO;
import com.fsd.sba.model.Project;
import com.fsd.sba.model.User;
import com.fsd.sba.service.ProjectService;
import com.fsd.sba.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Override
    public List<ProjectDTO> findAll() {

        List<Project> projects = projectRepository.findAll();
        List<ProjectDTO> projectDTOList = new ArrayList<>();

        for (Project project : projects) {
            User user = userRepository.findByProjectId(project.getId());
            ProjectDTO projectDTO = ProjectDTO.builder()
                    .projectId(project.getId())
                    .projectName(project.getProjectName())
                    .startDate(project.getStartDate())
                    .endDate(project.getEndDate())
                    .priority(project.getPriority())
                    .userId(user != null ? user.getUserId() : null)
                    .manager(user != null ? user.getFirstName() + user.getLastName() : String.valueOf(""))
                    .build();
            projectDTOList.add(projectDTO);
        }

/*        List<ProjectDTO> projectDTOList = projects.stream().map(project -> ProjectDTO.builder()
                .projectId(project.getTaskId())
                .projectName(project.getProjectName())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .priority(project.getPriority())
                .build()).collect(Collectors.toList());
       */
        return projectDTOList;

    }

    @Override
    public ProjectDTO findProject(Long id) {
        return null;
    }

    @Override
    public Project saveProject(ProjectDTO projectDTO) {

        // UserDTO userDTO = userService.findUser(projectDTO.getUserId());
        User user = userRepository.getOne(projectDTO.getUserId());

        Project project = Project.builder()
                .projectName(projectDTO.getProjectName())
                .endDate(projectDTO.getEndDate())
                .startDate(projectDTO.getStartDate())
                .priority(projectDTO.getPriority()).build();
        //.user(user).build();
             /*   .user(User.builder()
                        .empId(userDTO.getEmpId())
                        .firstName(userDTO.getFirstName())
                        .lastName(userDTO.getLastName())
                        .userId(userDTO.getUserId())
                        .build()).build();*/


        project = projectRepository.save(project);
        user.setProjectId(project.getId());
        userRepository.save(user);
        return project;
    }

    @Override
    public Project updateProject(ProjectDTO projectDTO) {

        Project project = projectRepository.getOne(projectDTO.getProjectId());

        project.setEndDate(projectDTO.getEndDate());
        project.setPriority(projectDTO.getPriority());
        project.setProjectName(projectDTO.getProjectName());
        project.setStartDate(projectDTO.getStartDate());
        return projectRepository.save(project);

    }


    User buildUserObject(UserDTO userDTO) {
        return User.builder()
                .empId(userDTO.getEmpId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .userId(userDTO.getUserId())
                .build();
    }
}
