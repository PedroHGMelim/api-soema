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

import com.aps.api_soema.model.Registro;
import com.aps.api_soema.repository.RegistroRepository;

@RestController 
@RequestMapping("/registro")
public class RegistroController {
    private final RegistroRepository repository;

    public RegistroController(RegistroRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Registro criar(@RequestBody Registro registro) {
        return repository.save(registro);
    }

    @GetMapping
    public List<Registro> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Registro buscar(@PathVariable Long id_registro) {
        return repository.findById(id_registro).orElse(null);
    }

    @PutMapping("/{id}")
    public Registro atualizar(@PathVariable Long id_registro,
                        @RequestBody Registro novoRegistro) {
        return repository.findById(id_registro).map(registro -> {
            registro.setData(novoRegistro.getData());
            registro.setBpm(novoRegistro.getBpm());
            return repository.save(registro);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id_registro) {
        repository.deleteById(id_registro);
    }
}