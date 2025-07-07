package com.todo.fullstack.domain.dto;

import com.todo.fullstack.domain.entity.Status;

public record UpdateTaskDataDTO(String title, String description, Status status, Long userId) {
}
