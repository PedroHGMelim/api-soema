package com.aps.api_soema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aps.api_soema.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // 🔐 Para login direto (não recomendado com senha criptografada)
    Usuario findByEmailAndSenha(String email, String senha);

    // 🔎 Para buscas específicas
    List<Usuario> findByEmailContaining(String parteDoEmail);

    // ✅ Novo método para login seguro
    Usuario findByEmail(String email);
}
