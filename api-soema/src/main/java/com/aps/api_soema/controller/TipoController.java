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

import com.aps.api_soema.model.Tipo;
import com.aps.api_soema.repository.TipoRepository;

@RestController 
@RequestMapping("/tipo")
public class TipoController {
    private final TipoRepository repository;

    public TipoController(TipoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Tipo criar(@RequestBody Tipo tipo) {
        return repository.save(tipo);
    }

    @GetMapping
    public List<Tipo> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Tipo buscar(@PathVariable Long id_tipo) {
        return repository.findById(id_tipo).orElse(null);
    }

    @PutMapping("/{id}")
    public Tipo atualizar(@PathVariable Long id_tipo,
                        @RequestBody Tipo novoTipo) {
        return repository.findById(id_tipo).map(tipo -> {
            tipo.setTipo(novoTipo.getTipo());
            return repository.save(tipo);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id_tipo) {
        repository.deleteById(id_tipo);
    }
}