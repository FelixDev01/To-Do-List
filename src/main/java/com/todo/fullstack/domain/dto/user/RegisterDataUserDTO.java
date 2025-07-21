package com.todo.fullstack.domain.dto.user;

import com.todo.fullstack.domain.entity.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterDataUserDTO(
        @NotBlank
        @Email(message = "Invalid email")
        String login,
        @NotBlank
        String senha) {

}
