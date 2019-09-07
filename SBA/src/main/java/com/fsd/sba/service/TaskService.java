package com.fsd.sba.service;


import com.fsd.sba.dto.ParentTaskDto;
import com.fsd.sba.dto.TaskDto;
import com.fsd.sba.model.Task;

import java.util.List;

public interface TaskService {
    public List<TaskDto> findTaskByProject(Long id);

    public List<ParentTaskDto> findAllParent();

    public TaskDto findTask(Long id);

    public void saveTask(TaskDto task);

    public Task updateTask(TaskDto task);

    public Task endTask(Long id);
}
