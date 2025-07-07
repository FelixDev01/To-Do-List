package com.todo.fullstack.domain.dto.task;

import com.todo.fullstack.domain.entity.Status;
import jakarta.validation.constraints.NotNull;

public record UpdateTaskDataDTO(

        String title,

        String description,

        Status status) {
}
