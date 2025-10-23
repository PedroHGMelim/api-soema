package com.aps.api_soema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    private String email;
    private String senha;
    private Long telefone;
    private Byte id_tipo;

    public Usuario() {}

    public Usuario(String email, String senha, Long telefone, Byte id_tipo) {
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.id_tipo = id_tipo;
    }

    //Getters e Setters
    public Long getIduser() { return id_usuario; }
    public void setIduser(Long id_usuario) { this.id_usuario = id_usuario; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha( String senha ) { this.senha = senha; }
    public Long getTelefone() { return telefone; }
    public void setTelefone(Long telefone) { this.telefone = telefone; }
    public Byte getIdtipo() { return id_tipo; }
    public void setIdtipo(Byte id_tipo) { this.id_tipo = id_tipo; }
}