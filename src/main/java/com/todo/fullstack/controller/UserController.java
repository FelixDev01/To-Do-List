package com.todo.fullstack.controller;

import com.todo.fullstack.config.TokenService;
import com.todo.fullstack.domain.dto.user.RegisterDataUserDTO;
import com.todo.fullstack.domain.dto.user.TokenJWTDataDTO;
import com.todo.fullstack.domain.entity.User;
import com.todo.fullstack.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

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
        var codeToken = tokenService.gerarToken((User) authentication.getPrincipal());


        return ResponseEntity.ok(new TokenJWTDataDTO(codeToken));
    }

}
