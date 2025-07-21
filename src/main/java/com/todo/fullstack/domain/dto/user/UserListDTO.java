package com.todo.fullstack.domain.dto.user;

import com.todo.fullstack.domain.entity.Status;
import com.todo.fullstack.domain.entity.Task;
import com.todo.fullstack.domain.entity.User;

public record UserListDTO(Long id, String login, String senha) {
    public UserListDTO(User user){
        this(user.getId(), user.getLogin(), user.getSenha());
    }
}
