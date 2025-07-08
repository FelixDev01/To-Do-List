package com.todo.fullstack.domain.dto.task;

import com.todo.fullstack.domain.entity.Status;
import com.todo.fullstack.domain.entity.Task;

public record TaskListDTO(
        Long id,
        String title,
        String description,
        Status status,
        Long userId) {
    public TaskListDTO(Task task){
        this(task.getId(), task.getTitle(), task.getDescription(), task.getStatus(), task.getUser().getId());
    }
}
