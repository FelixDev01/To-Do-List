package com.todo.fullstack.domain.dto.task;

import com.todo.fullstack.domain.entity.Status;
import com.todo.fullstack.domain.entity.Task;

public record DetailmentTaskDTO(
        Long id,
        String title,
        String description,
        Status status,
        Long userId)
{
    public DetailmentTaskDTO(Task task){
        this(task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getUser().getId());
    }
}
