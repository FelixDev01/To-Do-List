package com.todo.fullstack.domain.dto.task;

import com.todo.fullstack.domain.entity.Status;

public record RegisterDataTaksDTO(String title, String description, Status status, Long userId) {
}
