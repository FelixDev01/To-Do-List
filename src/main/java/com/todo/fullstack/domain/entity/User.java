package com.todo.fullstack.domain.entity;

import com.todo.fullstack.domain.dto.task.RegisterDataTaksDTO;
import com.todo.fullstack.domain.dto.user.RegisterDataUserDTO;
import com.todo.fullstack.domain.dto.user.UpdateUserDataDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_users")
@EqualsAndHashCode(of = "id")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;


    public User(RegisterDataUserDTO data) {
        this.name = data.name();
        this.email = data.email();
    }


    public void updateData(UpdateUserDataDTO data) {
        if (data.name() != null){
            this.name = data.name();
        }

        if (data.email() != null) {
            this.email = data.email();
        }
    }
}
