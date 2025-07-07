package com.todo.fullstack.domain.dto.task;

import com.todo.fullstack.domain.entity.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDataTaskDTO(
        @NotBlank
        String title,
        @NotBlank
        String description,
        @NotNull
        Status status,
        @NotNull
        Long userId) {
}
