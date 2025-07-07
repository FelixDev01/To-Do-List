package com.todo.fullstack.domain.dto.user;

import com.todo.fullstack.domain.entity.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterDataUserDTO(
        @NotBlank
        String name,
        @NotBlank(message = "Email is mandatory")
        @Email(message = "Invalid email")
        String email) {

}
