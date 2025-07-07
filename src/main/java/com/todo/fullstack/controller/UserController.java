package com.todo.fullstack.controller;

import com.todo.fullstack.domain.dto.user.DetailmentUserDTO;
import com.todo.fullstack.domain.dto.user.RegisterDataUserDTO;
import com.todo.fullstack.domain.dto.user.UpdateUserDataDTO;
import com.todo.fullstack.domain.dto.user.UserListDTO;
import com.todo.fullstack.domain.entity.User;
import com.todo.fullstack.domain.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetailmentUserDTO> register(@Valid @RequestBody RegisterDataUserDTO data, UriComponentsBuilder uriBuilder){
        var user = new User(data);
        repository.save(user);
        var uri = uriBuilder.path("/tasks/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailmentUserDTO(user));
    }

    @GetMapping
    public ResponseEntity<Page<UserListDTO>> list(Pageable pagination){
        var userPage = repository.findAll(pagination).map(UserListDTO::new);
        return ResponseEntity.ok().body(userPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailmentUserDTO> findById(@PathVariable Long id){
        var findUser= repository.getReferenceById(id);
        return ResponseEntity.ok().body(new DetailmentUserDTO(findUser));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetailmentUserDTO> update(@PathVariable Long id, @RequestBody UpdateUserDataDTO data){
        var user = repository.getReferenceById(id);
        user.updateData(data);
        return ResponseEntity.ok().body(new DetailmentUserDTO(user));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
