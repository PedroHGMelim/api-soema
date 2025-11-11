package com.aps.api_soema.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aps.api_soema.DTOs.LoginDTO;
import com.aps.api_soema.model.Usuario;
import com.aps.api_soema.repository.UsuarioRepository;

@RestController
@CrossOrigin(origins = "*") // permite chamadas do app React Native
public class LoginController {

    private final UsuarioRepository usuarioRepository;

    public LoginController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        // Busca o usuário pelo e-mail
        Usuario usuario = usuarioRepository.findByEmail(loginDTO.getEmail());

        // Verifica se o usuário existe e se a senha está correta
        if (usuario != null && usuario.getSenha().equals(loginDTO.getSenha())) {
            usuario.setSenha(null); // não retorna a senha
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha inválidos");
        }
    }
}
