package com.aps.api_soema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aps.api_soema.model.Pulseira;

public interface PulseiraRepository extends JpaRepository<Pulseira, Long> {
    List<Pulseira> findByUuidService(String uuid_service);
    List<Pulseira> findByUuidContaining(String parteDoUuid);
}