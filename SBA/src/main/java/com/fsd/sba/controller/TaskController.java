package com.fsd.sba.controller;

import com.fsd.sba.dto.TaskDto;
import com.fsd.sba.model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface TaskController {

    @RequestMapping(value = "/endTask/{taskId}", method = RequestMethod.PUT)
    public ResponseEntity endTask(@PathVariable("taskId") Long id, @RequestBody TaskDto taskDto) ;

    @RequestMapping(value = "/updateTask", method = RequestMethod.PUT)
    public ResponseEntity updateTask(@RequestBody TaskDto taskDto);

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public ResponseEntity<Task> addTask(@RequestBody TaskDto taskDto);

    @RequestMapping(value = "/task/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<TaskDto> getTask(@PathVariable("taskId") Long id);

    @RequestMapping(value = "/tasks/{projectId}", method = RequestMethod.GET)
    public ResponseEntity<List<TaskDto>> getAllTasks(@PathVariable("projectId") Long projectId);

}
