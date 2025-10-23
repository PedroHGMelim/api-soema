package com.aps.api_soema.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pulseira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid_service;
    private String uuid_characteristics;
    private Long id_usuario;

    public Pulseira() {}

    public Pulseira(String uuid_service, String uuid_characteristics, Long id_usuario) {
        this.uuid_service = uuid_service;
        this.uuid_characteristics = uuid_characteristics;
        this.id_usuario = id_usuario;
    }

    //Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUuidservice() { return uuid_service; }
    public void setUuidservice(String uuid_service) { this.uuid_service = uuid_service; }
    public String getUuidcharacteristics() { return uuid_characteristics; }
    public void setUuidcharacteristics( String uuid_characteristics ) { this.uuid_characteristics = uuid_characteristics; }
    public Long getIdusuario() { return id_usuario; }
    public void setIdusuario(Long id_usuario) { this.id_usuario = id_usuario; }
}