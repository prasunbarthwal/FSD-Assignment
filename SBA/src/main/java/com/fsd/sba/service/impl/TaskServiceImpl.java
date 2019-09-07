package com.fsd.sba.service.impl;

import com.fsd.sba.dao.ParentTaskRepository;
import com.fsd.sba.dao.ProjectRepository;
import com.fsd.sba.dao.TaskRepository;
import com.fsd.sba.dao.UserRepository;
import com.fsd.sba.dto.ParentTaskDto;
import com.fsd.sba.dto.TaskDto;
import com.fsd.sba.model.ParentTask;
import com.fsd.sba.model.Project;
import com.fsd.sba.model.Task;
import com.fsd.sba.model.User;
import com.fsd.sba.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@Slf4j
public class TaskServiceImpl implements TaskService {


    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ParentTaskRepository parentTaskRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectRepository projectRepository;


    @Override
    public TaskDto findTask(Long id) {

        log.debug("Inside find Task method");
        Task task = taskRepository.getOne(id);
        ParentTask parentTask = null;
        Project project = null;
        User user = null;
        if (Objects.nonNull(task.getParentId()))
            parentTask = parentTaskRepository.getOne(task.getParentId());
        if (Objects.nonNull(task.getProjectId()))
            project = projectRepository.getOne(task.getProjectId());

        user = userRepository.findByTaskId(task.getId());

        log.debug("Task found for taskId " + id);
        return TaskDto.builder()
                .taskId(task.getId())
                .endDate(task.getEndDate())
                .startDate(task.getStartDate())
                .task(task.getTask())
                .priority(task.getPriority())
                .parentTask(Objects.nonNull(parentTask) ? parentTask.getParentTask() : "")
                .projectId(task.getProjectId())
                .projectName(Objects.nonNull(project) ? project.getProjectName() : "")
                .isParent(false)
                .userName(Objects.nonNull(user) ? user.getFirstName() + " " + user.getLastName() : "")
                .userId(Objects.nonNull(user) ? user.getUserId() : null)
                //  .parentTask(task.get().getParentTask() != null ? task.get().getParentTask().getParentTask() : null)
                .build();
    }

    @Override
    public void saveTask(TaskDto taskDto) {

        log.debug("Inside save Task method");
        if (null != taskDto.getIsParent() && taskDto.getIsParent()) {
            ParentTask parentTask = ParentTask.builder()
                    .parentTask(taskDto.getParentTask()).build();

            parentTaskRepository.save(parentTask);
            return;

        } else {
            Task task = Task.builder().endDate(taskDto.getEndDate())
                    .startDate(taskDto.getStartDate())
                    .task(taskDto.getTask())
                    .priority(taskDto.getPriority())
                    .projectId(taskDto.getProjectId())
                    .parentId(taskDto.getParentTaskId())
                    .build();
            task = taskRepository.save(task);


            User user = userRepository.getOne(taskDto.getUserId());
            user.setTaskId(task.getId());
            userRepository.save(user);

        }

        //save task
    }


    @Override
    public Task updateTask(TaskDto taskDto) {

        Task task = taskRepository.getOne(taskDto.getTaskId());

        task.setEndDate(taskDto.getEndDate());
        task.setStartDate(taskDto.getStartDate());
        task.setTask(taskDto.getTask());
        task.setPriority(taskDto.getPriority());
        task.setProjectId(taskDto.getProjectId());
        task.setParentId(taskDto.getParentTaskId());
        task = taskRepository.save(task);


        User user = userRepository.getOne(taskDto.getUserId());
        user.setTaskId(task.getId());
        userRepository.save(user);

        return task;
    }

    @Override
    public Task endTask(Long id) {
        Task task = taskRepository.getOne(id);
        task.setStatus("COMPLETED");
        task.setEndDate(LocalDate.now());
        return taskRepository.save(task);
    }


    @Override
    public List<ParentTaskDto> findAllParent() {
        List<ParentTask> parentTaskList = parentTaskRepository.findAll();
        List<ParentTaskDto> parentTaskDtos = new ArrayList<>();
        for (ParentTask parentTask : parentTaskList) {
            ParentTaskDto parentTaskDto = ParentTaskDto.builder()
                    .parentTaskId(parentTask.getId())
                    .parentTask(parentTask.getParentTask()).build();

            parentTaskDtos.add(parentTaskDto);
        }


        return parentTaskDtos;

    }

    public List<TaskDto> findTaskByProject(Long id) {

        List<Task> taskList = taskRepository.findTaskByProjectId(id);

        List<TaskDto> taskDtoList = new ArrayList<>();

        for (Task task : taskList) {
            TaskDto taskDto = TaskDto.builder()
                    .taskId(task.getId())
                    .priority(task.getPriority())
                    .startDate(task.getStartDate())
                    .endDate(task.getEndDate())
                    .task(task.getTask())
                    .parentTask("")
                    .build();
            taskDtoList.add(taskDto);
        }

        return taskDtoList;

    }

}

/*
    @Override
    public TaskDto findTask(Long taskId) {

        log.debug("Inside find Task method");
        Optional<Task> task = taskRepository.findById(taskId);
        log.debug("Task found for taskId " + taskId);
        return TaskDto.builder()
                .taskId(task.get().getTaskId())
                .endDate(task.isPresent() ? task.get().getEndDate() : null)
                .startDate(task.isPresent() ? task.get().getStartDate() : null)
                .task(task.isPresent() ? task.get().getTask() : null)
                .priority(task.isPresent() ? task.get().getPriority() : null)
              //  .parentTask(task.get().getParentTask() != null ? task.get().getParentTask().getParentTask() : null)
                .build();
    }*/


//        @Override
/*
    public Task updateTask(TaskDto taskDto) {

        log.debug("Inside update Task method");
        Optional<Task> task = taskRepository.findById(taskDto.getTaskId());
        Task oldTask = task.get();
        log.debug("Found task for update with taskId" +task);
        oldTask.setTask(taskDto.getTask());
        oldTask.setPriority(taskDto.getPriority());
        oldTask.setEndDate(taskDto.getEndDate());
        oldTask.setStartDate(taskDto.getStartDate());
       */
/* if (Objects.nonNull(oldTask.getParentTask()))
            oldTask.getParentTask().setParentTask(taskDto.getParentTask());
        else
            oldTask.setParentTask(ParentTask.builder().parentTask(taskDto.getParentTask()).build());
*//*

        return taskRepository.save(oldTask);
    }


    @Override
    public Task endTask(Long taskId) {

        log.debug("Inside end Task method");
        Optional<Task> task = taskRepository.findById(taskId);
        task.get().setEndDate(LocalDate.now());
        log.debug("Task ended for Id" + taskId);
        return taskRepository.save(task.get());


    }
*/



