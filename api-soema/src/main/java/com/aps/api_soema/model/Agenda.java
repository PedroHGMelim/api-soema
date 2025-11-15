package com.aps.api_soema.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_agenda;
    private String titulo_agendamento;
    private Date data;
    private String notas;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private Usuario user;

    @OneToOne(mappedBy = "agenda", cascade = CascadeType.ALL)
    private Agenda agenda;

    public Agenda() {}

    public Agenda(String titulo_agendamento, Date data, Usuario user, String notas) {
        this.titulo_agendamento = titulo_agendamento;
        this.data = data;
        this.user = user;
        this.notas = notas;
    }

    //Getters e Setters
    public Long getId() { return id_agenda; }
    public void setId(Long id_agenda) { this.id_agenda = id_agenda; }
    public String getTitulo() { return titulo_agendamento; }
    public void setTitulo(String titulo_agendamento) { this.titulo_agendamento = titulo_agendamento; }
    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }
    public Usuario getUser() { return user; }
    public void setUser(Usuario user) { this.user = user; }
    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }
}