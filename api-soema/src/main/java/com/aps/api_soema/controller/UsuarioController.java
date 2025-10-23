package com.aps.api_soema.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aps.api_soema.model.Usuario;
import com.aps.api_soema.repository.UsuarioRepository;

@RestController 
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id_usuario) {
        return repository.findById(id_usuario).orElse(null);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id_usuario,
                        @RequestBody Usuario novoUsuario) {
        return repository.findById(id_usuario).map(usuario -> {
            usuario.setEmail(novoUsuario.getEmail());
            usuario.setSenha(novoUsuario.getSenha());
            usuario.setTelefone(novoUsuario.getTelefone());
            usuario.setIdtipo(novoUsuario.getIdtipo());
            return repository.save(usuario);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id_usuario) {
        repository.deleteById(id_usuario);
    }
}