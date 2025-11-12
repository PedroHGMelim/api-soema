package com.aps.api_soema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aps.api_soema.model.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findByIdAgenda(Long id_agenda);
    List<Agenda> findByIdUsuario(Long id_usuario);
}