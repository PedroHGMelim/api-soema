package com.aps.api_soema.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Pulseira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String uuidService;
    private String uuidCharacteristics;
    private String tipo;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "pulseira", cascade = CascadeType.ALL)
    private List<Pulseira> pulseira;

    public Pulseira() {}

    public Pulseira(String nome, String uuid, String uuidService, String uuidCharacteristics, String tipo, Usuario usuario) {
        this.nome = nome;
        this.uuidService = uuidService;
        this.uuidCharacteristics = uuidCharacteristics;
        this.tipo = tipo;
        this.usuario = usuario;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getUuidService() { return uuidService; }
    public void setUuidService(String uuidService) { this.uuidService = uuidService; }

    public String getUuidCharacteristics() { return uuidCharacteristics; }
    public void setUuidCharacteristics(String uuidCharacteristics) { this.uuidCharacteristics = uuidCharacteristics; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}