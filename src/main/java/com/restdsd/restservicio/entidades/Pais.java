package com.restdsd.restservicio.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_pais")
public class Pais implements Serializable {
    private static final long serialVersionUID = 8874519965258L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPais")
    private Long idpais;
    @Column(unique = true)
    private String pa_nombre;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ciudad> ciudades;

    public Long getIdpais() {
        return idpais;
    }

    public void setIdpais(Long idpais) {
        this.idpais = idpais;
    }

    public String getPa_nombre() {
        return pa_nombre;
    }

    public void setPa_nombre(String pa_nombre) {
        this.pa_nombre = pa_nombre;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
}
