package com.todo.fullstack.domain.entity;

import com.todo.fullstack.domain.dto.task.RegisterDataTaskDTO;
import com.todo.fullstack.domain.dto.task.UpdateTaskDataDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_task")
@EqualsAndHashCode(of = "id")
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  //private Long userId;

    public Task(RegisterDataTaskDTO data, User user) {
        this.title = data.title();
        this.description = data.description();
        this.status = data.status();
        this.user = user;
    }

    public void updateData(UpdateTaskDataDTO data) {

        if (data.title() != null){
            this.title = data.title();
        }

        if (data.description() != null){
            this.description = data.description();
        }

        if (data.status() != null){
            this.status = data.status();
        }
    }
}

