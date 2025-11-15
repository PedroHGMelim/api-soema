package com.aps.api_soema.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_registro;
    private Date dat;
    private Short bpm;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "uuid_service", nullable = false)
    private Pulseira pulseira;

    public Registro() {}

    public Registro(Date dat, Short bpm, Pulseira pulseira) {
        this.dat = dat;
        this.bpm = bpm;
        this.pulseira = pulseira;
    }

    //Getters e Setters
    public Long getId() { return id_registro; }
    public void setId(Long id_registro) { this.id_registro = id_registro; }
    public Short getBpm() { return bpm; }
    public void setBpm(Short bpm) { this.bpm = bpm; }
    public Date getData() { return dat; }
    public void setData(Date dat) { this.dat = dat; }
    public Pulseira getPulseira() { return pulseira; }
    public void setPulseira(Pulseira pulseira) { this.pulseira = pulseira; }
}