package com.todo.fullstack.domain.entity;

import com.todo.fullstack.domain.dto.RegisterDataDTO;
import com.todo.fullstack.domain.dto.UpdateTaskDataDTO;
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

    private Status status;

    private Long userId;

    public Task(RegisterDataDTO data) {
        this.title = data.title();
        this.description = data.description();
        this.status = data.status();
        this.userId = data.userId();
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

        if (data.userId() != null){
            this.userId = data.userId();
        }

    }
}

