package com.todo.fullstack.controller;

import com.todo.fullstack.domain.dto.user.DetailmentUserDTO;
import com.todo.fullstack.domain.dto.user.RegisterDataUserDTO;
import com.todo.fullstack.domain.dto.user.UpdateUserDataDTO;
import com.todo.fullstack.domain.dto.user.UserListDTO;
import com.todo.fullstack.domain.entity.AutenticacaoService;
import com.todo.fullstack.domain.entity.User;
import com.todo.fullstack.domain.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDataUserDTO data) {
        String senhaCriptografada = passwordEncoder.encode(data.senha());

        User user = new User();
        user.setLogin(data.login());
        user.setSenha(senhaCriptografada);

        userRepository.save(user);
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody RegisterDataUserDTO dados){
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(token);
        return ResponseEntity.ok().build();
    }

}
