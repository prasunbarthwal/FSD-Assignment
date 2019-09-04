package com.fsd.sba.service.impl;

import com.fsd.sba.dao.ParentTaskRepository;
import com.fsd.sba.dao.TaskRepository;
import com.fsd.sba.dao.UserRepository;
import com.fsd.sba.dto.ProjectDTO;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.DoubleStream;

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

    @Override
    public TaskDto findTask(Long id) {
        return null;
    }

    @Override
    public void saveTask(TaskDto taskDto) {

        log.debug("Inside save Task method");
        if (taskDto.getIsParent()) {
            ParentTask parentTask = ParentTask.builder()
                    .parentTask(taskDto.getParentTask()).build();

            parentTaskRepository.save(parentTask);

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
    public Task updateTask(TaskDto task) {
        return null;
    }

    @Override
    public Task endTask(Long id) {
        return null;
    }


    public List<TaskDto> findTaskByProject(Long id) {

        List<Task> taskList = taskRepository.findTaskByProjectId(id);

        List<TaskDto> taskDtoList = new ArrayList<>();

        for (Task task : taskList) {
            TaskDto taskDto = TaskDto.builder()
                    .id(task.getId())
                    .priority(task.getPriority())
                    .startDate(task.getStartDate())
                    .endDate(task.getEndDate())
                    .task(task.getTask())
                    .parentTask("")
                    .build();
        }

        return taskDtoList;

    }

}

/*
    @Override
    public TaskDto findTask(Long id) {

        log.debug("Inside find Task method");
        Optional<Task> task = taskRepository.findById(id);
        log.debug("Task found for id " + id);
        return TaskDto.builder()
                .id(task.get().getId())
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
        Optional<Task> task = taskRepository.findById(taskDto.getId());
        Task oldTask = task.get();
        log.debug("Found task for update with id" +task);
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
    public Task endTask(Long id) {

        log.debug("Inside end Task method");
        Optional<Task> task = taskRepository.findById(id);
        task.get().setEndDate(LocalDate.now());
        log.debug("Task ended for Id" + id);
        return taskRepository.save(task.get());


    }
*/



