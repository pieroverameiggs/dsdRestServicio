package com.restdsd.restservicio.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import javafx.util.converter.DateTimeStringConverter;
//import javafx.util.converter.DateTimeStringConverter;

import javax.persistence.*;
import java.io.Serializable;
//import java.sql.Timestamp;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_destino")
public class Destino implements Serializable {
    private static final long serialVersionUID = 5418963325417L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDestino")
    private Long iddestino;
    @ManyToOne
    @JoinColumn(name = "IdCiudad")
    @JsonIgnore
    private Ciudad de_ciudad;
    @ManyToOne
    @JoinColumn(name = "IdPais")
    @JsonIgnore
    private Pais de_pais;
    private String de_titpequenho;
    private String de_titprincipal;
    private String de_descripcioncorta;
    private String de_descripcionlarga;
    private String de_img1;
    private String de_img2;
    private String de_img3;
    private int de_vecesutilizado;
    private String de_googlemaps;
    private int de_userRegister;
    private Timestamp de_regiserDate;
    private int de_userUpdate;
    private Timestamp de_registerUpdate;

    @OneToMany(mappedBy = "destino", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Hotel> hoteles;

    @OneToMany(mappedBy = "destino", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RentaCarro> rentaCarros;

    public List<RentaCarro> getRentaCarros() {
        return rentaCarros;
    }

    public void setRentaCarros(List<RentaCarro> rentaCarros) {
        this.rentaCarros = rentaCarros;
    }

    public List<Hotel> getHoteles() {
        return hoteles;
    }

    public void setHoteles(List<Hotel> hoteles) {
        this.hoteles = hoteles;
    }

    public Long getIddestino() {
        return iddestino;
    }

    public void setIddestino(Long iddestino) {
        this.iddestino = iddestino;
    }

    public Ciudad getDe_ciudad() {
        return de_ciudad;
    }

    public void setDe_ciudad(Ciudad de_ciudad) {
        this.de_ciudad = de_ciudad;
    }

    public Pais getDe_pais() {
        return de_pais;
    }

    public void setDe_pais(Pais de_pais) {
        this.de_pais = de_pais;
    }

    public String getDe_titpequenho() {
        return de_titpequenho;
    }

    public void setDe_titpequenho(String de_titpequenho) {
        this.de_titpequenho = de_titpequenho;
    }

    public String getDe_titprincipal() {
        return de_titprincipal;
    }

    public void setDe_titprincipal(String de_titprincipal) {
        this.de_titprincipal = de_titprincipal;
    }

    public String getDe_descripcioncorta() {
        return de_descripcioncorta;
    }

    public void setDe_descripcioncorta(String de_descripcioncorta) {
        this.de_descripcioncorta = de_descripcioncorta;
    }

    public String getDe_descripcionlarga() {
        return de_descripcionlarga;
    }

    public void setDe_descripcionlarga(String de_descripcionlarga) {
        this.de_descripcionlarga = de_descripcionlarga;
    }

    public String getDe_img1() {
        return de_img1;
    }

    public void setDe_img1(String de_img1) {
        this.de_img1 = de_img1;
    }

    public String getDe_img2() {
        return de_img2;
    }

    public void setDe_img2(String de_img2) {
        this.de_img2 = de_img2;
    }

    public String getDe_img3() {
        return de_img3;
    }

    public void setDe_img3(String de_img3) {
        this.de_img3 = de_img3;
    }

    public int getDe_vecesutilizado() {
        return de_vecesutilizado;
    }

    public void setDe_vecesutilizado(int de_vecesutilizado) {
        this.de_vecesutilizado = de_vecesutilizado;
    }

    public String getDe_googlemaps() {
        return de_googlemaps;
    }

    public void setDe_googlemaps(String de_googlemaps) {
        this.de_googlemaps = de_googlemaps;
    }

    public int getDe_userRegister() {
        return de_userRegister;
    }

    public void setDe_userRegister(int de_userRegister) {
        this.de_userRegister = de_userRegister;
    }

    public Timestamp getDe_regiserDate() {
        return de_regiserDate;
    }

    public void setDe_regiserDate(Timestamp de_regiserDate) {
        this.de_regiserDate = de_regiserDate;
    }

    public int getDe_userUpdate() {
        return de_userUpdate;
    }

    public void setDe_userUpdate(int de_userUpdate) {
        this.de_userUpdate = de_userUpdate;
    }

    public Timestamp getDe_registerUpdate() {
        return de_registerUpdate;
    }

    public void setDe_registerUpdate(Timestamp de_registerUpdate) {
        this.de_registerUpdate = de_registerUpdate;
    }
}
