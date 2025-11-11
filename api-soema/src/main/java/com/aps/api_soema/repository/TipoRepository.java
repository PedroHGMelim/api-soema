package com.aps.api_soema.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.aps.api_soema.model.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long> {
    // Busca exata pelo id_tipo (tipo Byte)
    List<Tipo> findById(Byte idTipo);

    // ❌ REMOVIDO: Containing não funciona com Byte
    // List<Tipo> findByIdContaining(Byte partedoIdTipo);
}
