package com.stewm.task.domain.dto;

import com.stewm.task.domain.entity.TaskPriority;
import com.stewm.task.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDTO(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
