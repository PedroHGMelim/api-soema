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

import com.aps.api_soema.model.Agenda;
import com.aps.api_soema.repository.AgendaRepository;

@RestController 
@RequestMapping("/agenda")
public class AgendaController {
    private final AgendaRepository repository;

    public AgendaController(AgendaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Agenda criar(@RequestBody Agenda agenda) {
        return repository.save(agenda);
    }

    @GetMapping
    public List<Agenda> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Agenda buscar(@PathVariable Long id_agenda) {
        return repository.findById(id_agenda).orElse(null);
    }

    @GetMapping("/agenda/{id}")
    public List<Agenda> buscarPorUsuario(@PathVariable Long id_usuario) {
        return repository.findByIdUsuario(id_usuario);
    }

    @PutMapping("/{id}")
    public Agenda atualizar(@PathVariable Long id_agenda,
                        @RequestBody Agenda novaAgenda) {
        return repository.findById(id_agenda).map(agenda -> {
                agenda.setTitulo(novaAgenda.getTitulo());
                agenda.setData(novaAgenda.getData());
                agenda.setIdUser(novaAgenda.getIdUser());
                agenda.setNotas(novaAgenda.getNotas());
                return repository.save(agenda);
            }).orElse(null);
    }
    
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id_agenda) {
        repository.deleteById(id_agenda);
    }
}