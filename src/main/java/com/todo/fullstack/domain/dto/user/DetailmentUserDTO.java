package com.todo.fullstack.domain.dto.user;

import com.todo.fullstack.domain.entity.User;

public record DetailmentUserDTO(Long id, String login, String senha) {
    public DetailmentUserDTO(User user){
        this(user.getId(), user.getLogin(), user.getSenha());
    }
}
