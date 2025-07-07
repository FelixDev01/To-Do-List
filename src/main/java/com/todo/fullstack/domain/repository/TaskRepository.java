package com.todo.fullstack.domain.repository;

import com.todo.fullstack.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
