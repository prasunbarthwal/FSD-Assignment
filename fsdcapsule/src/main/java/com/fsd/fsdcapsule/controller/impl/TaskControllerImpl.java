package com.fsd.fsdcapsule.controller.impl;

import com.fsd.fsdcapsule.controller.TaskController;
import com.fsd.fsdcapsule.dto.TaskDto;
import com.fsd.fsdcapsule.model.Task;
import com.fsd.fsdcapsule.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/fsd")
@Slf4j
public class TaskControllerImpl implements TaskController {

    @Autowired
    TaskService taskService;


    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getAllTasks() {

        log.debug("Entered getAllTasks Request Mapping ");
        List<Task> taskList = taskService.findAll();
        return ResponseEntity.ok().body(taskList);
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    public ResponseEntity<TaskDto> getTask(@PathVariable("id") Long id) {

        log.debug("Entered getTask Request Mapping ");
        TaskDto task = taskService.findTask(id);
        log.debug("found Task for Id " + id);
        return ResponseEntity.ok().body(task);
    }

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public ResponseEntity<Task> addTask(@RequestBody TaskDto taskDto) {

        log.debug("Entered addTask Request Mapping ");
        Task task = taskService.saveTask(taskDto);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/endTask/{id}", method = RequestMethod.PUT)
    public ResponseEntity endTask(@PathVariable("id") Long id, @RequestBody Object task) {

        log.debug("End Task for task Id" + id);
        taskService.endTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/updateTask", method = RequestMethod.PUT)
    public ResponseEntity updateTask(@RequestBody TaskDto taskDto) {

        log.debug("Entered updateTask Request Mapping ");
        Task task = taskService.updateTask(taskDto);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}