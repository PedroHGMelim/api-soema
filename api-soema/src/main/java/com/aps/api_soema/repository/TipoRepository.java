package com.aps.api_soema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aps.api_soema.model.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long> {
    List<Tipo> findById(Byte id_tipo);
}