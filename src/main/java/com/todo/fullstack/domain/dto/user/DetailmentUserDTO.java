package com.todo.fullstack.domain.dto.user;

import com.todo.fullstack.domain.entity.User;

public record DetailmentUserDTO(Long id, String name, String email) {
    public DetailmentUserDTO(User user){
        this(user.getId(), user.getName(), user.getEmail());
    }
}
