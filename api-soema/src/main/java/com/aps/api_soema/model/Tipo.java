package com.aps.api_soema.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id_tipo;
    private String tipo;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<Tipo> type;

    public Tipo() {}

    public Tipo(String tipo) {
        this.tipo = tipo;
    }

    //Getters e Setters
    public Byte getId() { return id_tipo; }
    public void setId(Byte id_tipo) { this.id_tipo = id_tipo; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}