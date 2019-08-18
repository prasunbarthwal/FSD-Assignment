package com.fsd.fsdcapsule.controller;

import com.fsd.fsdcapsule.dto.TaskDto;
import com.fsd.fsdcapsule.model.Task;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface TaskController {

    @RequestMapping(value = "/endTask/{id}", method = RequestMethod.PUT)
    public ResponseEntity endTask(@PathVariable("id") Long id,@RequestBody Object task) ;

    @RequestMapping(value = "/updateTask", method = RequestMethod.PUT)
    public ResponseEntity updateTask(@RequestBody TaskDto taskDto) ;

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public ResponseEntity<Task> addTask(@RequestBody TaskDto taskDto) ;

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    public ResponseEntity<TaskDto> getTask(@PathVariable("id") Long id) ;

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public ResponseEntity <List<Task>> getAllTasks() ;



}
