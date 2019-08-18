package com.fsd.fsdcapsule.service;

import com.fsd.fsdcapsule.dto.TaskDto;
import com.fsd.fsdcapsule.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
   public  List<Task> findAll();
   public TaskDto findTask(Long id);
   public Task saveTask(TaskDto task);
   public Task updateTask(TaskDto task);
   public Task endTask(Long id);
}
