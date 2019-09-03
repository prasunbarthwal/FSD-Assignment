package com.fsd.sba.service;


import com.fsd.sba.dto.TaskDto;
import com.fsd.sba.model.Task;

import java.util.List;

public interface TaskService {
    public List<Task> findAll();

    public TaskDto findTask(Long id);

    public Task saveTask(TaskDto task);

    public Task updateTask(TaskDto task);

    public Task endTask(Long id);
}
