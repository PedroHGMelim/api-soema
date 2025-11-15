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

import com.aps.api_soema.model.Pulseira;
import com.aps.api_soema.repository.PulseiraRepository;

@RestController 
@RequestMapping("/pulseira")
public class PulseiraController {
    private final PulseiraRepository repository;

    public PulseiraController(PulseiraRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Pulseira criar(@RequestBody Pulseira pulseira) {
        return repository.save(pulseira);
    }

    @GetMapping
    public List<Pulseira> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Pulseira buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/usuario/{id}")
    public List<Pulseira> listarPorUsuario(@PathVariable Long id) {
        return repository.findByUsuarioId(id);
    }

    @PutMapping("/{id}")
    public Pulseira atualizar(@PathVariable Long id, 
                            @RequestBody Pulseira novaPulseira) {
        return repository.findById(id).map(pulseira -> {
                pulseira.setNome(novaPulseira.getNome());
                pulseira.setUuidService(novaPulseira.getUuidService());
                pulseira.setUuidCharacteristics(novaPulseira.getUuidCharacteristics());
                pulseira.setTipo(novaPulseira.getTipo());
                pulseira.setUsuario(novaPulseira.getUsuario());
                return repository.save(pulseira);
            })
            .orElse(null);
    }

    
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}