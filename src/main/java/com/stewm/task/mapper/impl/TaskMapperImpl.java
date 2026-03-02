package com.stewm.task.mapper.impl;

import com.stewm.task.domain.CreateTaskRequest;
import com.stewm.task.domain.UpdateTaskRequest;
import com.stewm.task.domain.dto.CreateTaskRequestDTO;
import com.stewm.task.domain.dto.TaskDTO;
import com.stewm.task.domain.dto.UpdateTaskRequestDTO;
import com.stewm.task.domain.entity.Task;
import com.stewm.task.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public CreateTaskRequest fromDTO(CreateTaskRequestDTO dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority()
        );
    }

    @Override
    public UpdateTaskRequest fromDTO(UpdateTaskRequestDTO dto) {
        return new UpdateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.status(),
                dto.priority()
        );
    }

    @Override
    public TaskDTO toDTO(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}
