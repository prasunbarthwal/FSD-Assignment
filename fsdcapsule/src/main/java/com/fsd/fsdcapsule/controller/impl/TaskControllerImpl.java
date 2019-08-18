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
/*
    @RequestMapping(value = "/task/", method = RequestMethod.POST)

    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task newBook = bookJpaRepository.save(book);
        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/task/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Task> updateTask(@PathVariable("id") String id, @RequestBody Task task) {

        Optional<Book> currentBook = bookJpaRepository.findById(Long.parseLong(id));
        if (!currentBook.isPresent()) {
            return new ResponseEntity(new CustomErrorType("Unable to update. Book with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        if (currentBook.isPresent()) {
            currentBook.get().setTitle(book.getTitle());
            currentBook.get().setVolume(book.getVolume());
            currentBook.get().setPrice(book.getPrice());
            currentBook.get().setPublishDate(book.getPublishDate());

        }
        Book newBook = bookJpaRepository.save(currentBook.get());
        return ResponseEntity.ok().body(newBook);
    }





    */

    @RequestMapping(value = "/endTask/{id}", method = RequestMethod.PUT)
    public ResponseEntity endTask(@PathVariable("id") Long id,@RequestBody Object task) {

         taskService.endTask(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(value = "/updateTask", method = RequestMethod.PUT)
    public ResponseEntity updateTask(@RequestBody TaskDto taskDto) {

        Task task = taskService.updateTask(taskDto);

        return new ResponseEntity<>(HttpStatus.OK);

    }
    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public ResponseEntity<Task> addTask(@RequestBody TaskDto taskDto) {
        Task task = taskService.saveTask(taskDto);
        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    public ResponseEntity<TaskDto> getTask(@PathVariable("id") Long id) {
        TaskDto task  =  taskService.findTask(id);
        return ResponseEntity.ok().body(task);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public ResponseEntity <List<Task>> getAllTasks() {


        List<Task> taskList =  taskService.findAll();
        return ResponseEntity.ok().body(taskList);
    }


    }