package com.aps.api_soema.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_agenda;
    private String titulo_agendamento;
    private Date data;
    private Long id_usuario;
    private String notas;

    public Agenda() {}

    public Agenda(String titulo_agendamento, Date data, Long id_usuario, String notas) {
        this.titulo_agendamento = titulo_agendamento;
        this.data = data;
        this.id_usuario = id_usuario;
        this.notas = notas;
    }

    //Getters e Setters
    public Long getId() { return id_agenda; }
    public void setId(Long id_agenda) { this.id_agenda = id_agenda; }
    public String getTitulo() { return titulo_agendamento; }
    public void setTitulo(String titulo_agendamento) { this.titulo_agendamento = titulo_agendamento; }
    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }
    public Long getIdUser() { return id_usuario; }
    public void setIdUser(Long id_usuario) { this.id_usuario = id_usuario; }
    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }
}