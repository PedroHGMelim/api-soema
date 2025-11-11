package com.aps.api_soema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aps.api_soema.model.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Long> {
    List<Registro> findByUuidService(String uuidService);
    List<Registro> findByUuidServiceContaining(String parteDoUuid);
}
