package com.stewm.task.domain;

import com.stewm.task.domain.entity.TaskPriority;
import com.stewm.task.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority
) {

}
