package com.stewm.task.controller;

import com.stewm.task.domain.CreateTaskRequest;
import com.stewm.task.domain.UpdateTaskRequest;
import com.stewm.task.domain.dto.CreateTaskRequestDTO;
import com.stewm.task.domain.dto.TaskDTO;
import com.stewm.task.domain.dto.UpdateTaskRequestDTO;
import com.stewm.task.domain.entity.Task;
import com.stewm.task.mapper.TaskMapper;
import com.stewm.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(
           @Valid @RequestBody CreateTaskRequestDTO createTaskRequestDTO
    ){
        CreateTaskRequest createTaskRequest = taskMapper.fromDTO(createTaskRequestDTO);
        Task task = taskService.createTask(createTaskRequest);
        TaskDTO createTaskdto = taskMapper.toDTO(task);
        return new ResponseEntity<>(createTaskdto, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<TaskDTO>> listTask(){
       List<Task> tasks = taskService.listTask();
       List<TaskDTO> taskDTOS = tasks.stream().map(taskMapper::toDTO).toList();
       return ResponseEntity.ok(taskDTOS);
    }

    @PutMapping(path = "/{taskId}")
    public ResponseEntity<TaskDTO> updateTask(
            @PathVariable UUID taskId,
            @Valid @RequestBody UpdateTaskRequestDTO updateTaskRequestDTO
            ){
        UpdateTaskRequest updateTaskRequest = taskMapper.fromDTO(updateTaskRequestDTO);
        Task task = taskService.updateTask(taskId, updateTaskRequest);
        TaskDTO updatedTaskDTO = taskMapper.toDTO(task);

        return ResponseEntity.ok(updatedTaskDTO);

    }

    @DeleteMapping(path = "/{taskId}")
    public ResponseEntity<Void> deleteTask (@PathVariable UUID taskId){
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
