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
    private Pais ci_pais;

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

    public Pais getCi_pais() {
        return ci_pais;
    }

    public void setCi_pais(Pais ci_pais) {
        this.ci_pais = ci_pais;
    }
}
