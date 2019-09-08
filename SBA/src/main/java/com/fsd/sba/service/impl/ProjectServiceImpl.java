package com.fsd.sba.service.impl;

import com.fsd.sba.dao.ProjectRepository;
import com.fsd.sba.dao.TaskRepository;
import com.fsd.sba.dao.UserRepository;
import com.fsd.sba.dto.ProjectDTO;
import com.fsd.sba.dto.UserDTO;
import com.fsd.sba.model.Project;
import com.fsd.sba.model.Task;
import com.fsd.sba.model.User;
import com.fsd.sba.service.ProjectService;
import com.fsd.sba.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    TaskRepository taskRepository;

    @Autowired
    UserService userService;

    @Override
    public List<ProjectDTO> findAll() {
        log.debug("Find All operation started");

        List<Project> projects = projectRepository.findAll();
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        log.debug("Found projects :"+projects);

        for (Project project : projects) {
            User user = userRepository.findByProjectId(project.getId());
            List<Task> totalTask = taskRepository.findTaskByProjectId(project.getId());
            List<Task> completedTask = taskRepository.findTaskByProjectIdAndStatus(project.getId(),"COMPLETED");
            ProjectDTO projectDTO = ProjectDTO.builder()
                    .projectId(project.getId())
                    .projectName(project.getProjectName())
                    .startDate(project.getStartDate())
                    .endDate(project.getEndDate())
                    .priority(project.getPriority())
                    .userId(user != null ? user.getUserId() : null)
                    .manager(user != null ? user.getFirstName() + user.getLastName() : String.valueOf(""))
                    .totalTask(Objects.nonNull(totalTask)?totalTask.size():0)
                    .completedTask(Objects.nonNull(completedTask)?completedTask.size():0)
                    .build();
            projectDTOList.add(projectDTO);
        }


        return projectDTOList;

    }



    @Override
    public Project saveProject(ProjectDTO projectDTO) {

        // UserDTO userDTO = userService.findUser(projectDTO.getUserId());
        User user = userRepository.getOne(projectDTO.getUserId());
        log.debug("User found for project:");

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
        log.debug("User saved successfully");

        return project;
    }

    @Override
    public Project updateProject(ProjectDTO projectDTO) {
        log.debug("update Project method started");

        Project project = projectRepository.getOne(projectDTO.getProjectId());

        project.setEndDate(projectDTO.getEndDate());
        project.setPriority(projectDTO.getPriority());
        project.setProjectName(projectDTO.getProjectName());
        project.setStartDate(projectDTO.getStartDate());
        return projectRepository.save(project);


    }



}
