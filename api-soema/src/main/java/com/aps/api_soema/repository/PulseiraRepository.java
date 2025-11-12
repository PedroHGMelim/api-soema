package com.aps.api_soema.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aps.api_soema.model.Pulseira;

@Repository
public interface PulseiraRepository extends JpaRepository<Pulseira, Long> {

    // Buscar pulseiras por UUID exato
    List<Pulseira> findByUuidService(String uuidService);
    List<Pulseira> findByUuidCharacteristics(String uuidCharacteristics);

    // Buscar pulseiras por parte do UUID
    List<Pulseira> findByUuidServiceContaining(String parteDoUuid);

    // Buscar pulseiras de um usuário específico
    List<Pulseira> findByUsuarioId(Long id);
}