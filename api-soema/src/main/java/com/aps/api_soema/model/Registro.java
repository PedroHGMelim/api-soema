package com.aps.api_soema.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_registro;
    private Date dat;
    private Short bpm;
    private String uuid_service;

    public Registro() {}

    public Registro(Date dat, Short bpm) {
        this.dat = dat;
        this.bpm = bpm;
    }

    //Getters e Setters
    public Long getId() { return id_registro; }
    public void setId(Long id_registro) { this.id_registro = id_registro; }
    public Short getBpm() { return bpm; }
    public void setBpm(Short bpm) { this.bpm = bpm; }
    public Date getData() { return dat; }
    public void setData(Date dat) { this.dat = dat; }
    public String getUuidservice() { return uuid_service; }
    public void setUuidservice(String uuid_service) { this.uuid_service = uuid_service; }
}