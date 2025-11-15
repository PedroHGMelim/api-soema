package com.aps.api_soema.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    private String email;
    private String senha;
    private Long telefone;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_tipo", nullable = false)
    private Tipo type;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Usuario> usuario;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Usuario user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agenda", nullable = false)
    private Agenda agenda;

    public Usuario() {}

    public Usuario(String email, String senha, Long telefone, Tipo type, Agenda agenda) {
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.type = type;
        this.agenda = agenda;
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
    public Tipo getType() { return type; }
    public void setType(Tipo type) { this.type = type; }
    public Agenda getAgenda() { return agenda; }
    public void setAgenda(Agenda agenda) { this.agenda = agenda; }
}