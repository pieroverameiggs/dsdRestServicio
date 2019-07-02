package com.restdsd.restservicio.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_ciudad")
public class Ciudad implements Serializable {
    private static final long serialVersionUID = 4441852310251L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCiudad")
    private Long idciudad;
    private String ci_nombre;
    @ManyToOne
    @JoinColumn(name = "IdPais")
    @JsonIgnore
    private Pais pais;
    
    public Long getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Long idciudad) {
        this.idciudad = idciudad;
    }

    public String getCi_nombre() {
        return ci_nombre;
    }

    public void setCi_nombre(String ci_nombre) {
        this.ci_nombre = ci_nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
