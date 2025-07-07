package com.todo.fullstack.domain.repository;

import com.todo.fullstack.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
