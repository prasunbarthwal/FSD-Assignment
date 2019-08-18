package com.fsd.fsdcapsule.controller;

import com.fsd.fsdcapsule.model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface TaskController {

   /* @RequestMapping(value = "/task/", method = RequestMethod.POST)
    public ResponseEntity<Task> addTask(@RequestBody Task task) ;

    @RequestMapping(value = "/task/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Task> updateTask(@PathVariable("id") String id, @RequestBody Task task);

    @RequestMapping(value = "/endTask/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Task> endTask(@PathVariable("id") String id, @RequestBody Task task);

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> getTask(@PathVariable("id") String id);*/


    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public ResponseEntity <List<Task>>getAllTasks();

}
