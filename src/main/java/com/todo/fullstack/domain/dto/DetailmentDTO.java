package com.todo.fullstack.domain.dto;

import com.todo.fullstack.domain.entity.Status;
import com.todo.fullstack.domain.entity.Task;

public record DetailmentDTO(Long id, String title, String description, Status status, Long userId) {
    public DetailmentDTO(Task task){
        this(task.getId(), task.getTitle(), task.getDescription(), task.getStatus(), task.getUserId());
    }
}
