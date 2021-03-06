package com.fsd.fsdcapsule.service.impl;

import com.fsd.fsdcapsule.dao.TaskRepository;
import com.fsd.fsdcapsule.dto.ParentTaskDto;
import com.fsd.fsdcapsule.dto.TaskDto;
import com.fsd.fsdcapsule.model.ParentTask;
import com.fsd.fsdcapsule.model.Task;
import com.fsd.fsdcapsule.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;


    public List<Task> findAll() {

        return taskRepository.findAll();
    }


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
                .parentTask(task.get().getParentTask() != null ? task.get().getParentTask().getParentTask() : null)
                .build();
    }


    @Override
    public Task updateTask(TaskDto taskDto) {

        log.debug("Inside update Task method");
        Optional<Task> task = taskRepository.findById(taskDto.getId());
        Task oldTask = task.get();
        log.debug("Found task for update with id" +task);
        oldTask.setTask(taskDto.getTask());
        oldTask.setPriority(taskDto.getPriority());
        oldTask.setEndDate(taskDto.getEndDate());
        oldTask.setStartDate(taskDto.getStartDate());
        if (Objects.nonNull(oldTask.getParentTask()))
            oldTask.getParentTask().setParentTask(taskDto.getParentTask());
        else
            oldTask.setParentTask(ParentTask.builder().parentTask(taskDto.getParentTask()).build());

        return taskRepository.save(oldTask);
    }

    @Override
    public Task saveTask(TaskDto taskDto) {

        log.debug("Inside save Task method");

        Task task = Task.builder().endDate(taskDto.getEndDate())
                .startDate(taskDto.getStartDate())
                .task(taskDto.getTask())
                .priority(taskDto.getPriority())
                .parentTask((taskDto.getParentTask() != null && taskDto.getParentTask() != "") ? ParentTask.builder().parentTask(taskDto.getParentTask()).build() : null)
                .build();
        return taskRepository.save(task);
    }

    @Override
    public Task endTask(Long id) {

        log.debug("Inside end Task method");
        Optional<Task> task = taskRepository.findById(id);
        task.get().setEndDate(LocalDate.now());
        log.debug("Task ended for Id" + id);
        return taskRepository.save(task.get());


    }


}
