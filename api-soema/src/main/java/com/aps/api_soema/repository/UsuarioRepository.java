package com.aps.api_soema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aps.api_soema.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmailAndSenha(String email, String senha);

    List<Usuario> findByEmailContaining(String parteDoEmail);

    Usuario findByEmail(String email);
}