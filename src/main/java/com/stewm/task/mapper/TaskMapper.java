package com.stewm.task.mapper;

import com.stewm.task.domain.CreateTaskRequest;
import com.stewm.task.domain.UpdateTaskRequest;
import com.stewm.task.domain.dto.CreateTaskRequestDTO;
import com.stewm.task.domain.dto.TaskDTO;
import com.stewm.task.domain.dto.UpdateTaskRequestDTO;
import com.stewm.task.domain.entity.Task;

public interface TaskMapper {

    CreateTaskRequest fromDTO(CreateTaskRequestDTO dto);

    UpdateTaskRequest fromDTO(UpdateTaskRequestDTO dto);

    TaskDTO toDTO(Task task);

}
