package com.stewm.task.service;

import com.stewm.task.domain.CreateTaskRequest;
import com.stewm.task.domain.UpdateTaskRequest;
import com.stewm.task.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task createTask(CreateTaskRequest request);

    List<Task> listTask();

    Task updateTask(UUID taskId, UpdateTaskRequest request);

    void deleteTask(UUID taskI);
}
