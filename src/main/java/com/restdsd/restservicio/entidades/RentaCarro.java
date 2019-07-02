package com.restdsd.restservicio.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.List;

@Entity
@Table(name = "tb_rentacarro")
public class RentaCarro implements Serializable {
    private static final long serialVersionUID = 1115201222587L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRentaCarro")
    private Long idrentacarro;
    @ManyToOne
    @JoinColumn(name = "IdDestino")
    @JsonIgnore
    private Destino destino;

    private String rc_titulo;
    private String rc_descripcioncorta;
    private String rc_descripcionlarga;
    private String rc_img1;
    private String rc_img2;
    private String rc_img3;
    private Long de_userRegister;
    private Timestamp de_regiserDate;
    private Long de_userUpdate;
    private Timestamp de_registerUpdate;


    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Long getIdrentacarro() {
        return idrentacarro;
    }

    public void setIdrentacarro(Long idrentacarro) {
        this.idrentacarro = idrentacarro;
    }

    public String getRc_titulo() {
        return rc_titulo;
    }

    public void setRc_titulo(String rc_titulo) {
        this.rc_titulo = rc_titulo;
    }

    public String getRc_descripcioncorta() {
        return rc_descripcioncorta;
    }

    public void setRc_descripcioncorta(String rc_descripcioncorta) {
        this.rc_descripcioncorta = rc_descripcioncorta;
    }

    public String getRc_descripcionlarga() {
        return rc_descripcionlarga;
    }

    public void setRc_descripcionlarga(String rc_descripcionlarga) {
        this.rc_descripcionlarga = rc_descripcionlarga;
    }

    public String getRc_img1() {
        return rc_img1;
    }

    public void setRc_img1(String rc_img1) {
        this.rc_img1 = rc_img1;
    }

    public String getRc_img2() {
        return rc_img2;
    }

    public void setRc_img2(String rc_img2) {
        this.rc_img2 = rc_img2;
    }

    public String getRc_img3() {
        return rc_img3;
    }

    public void setRc_img3(String rc_img3) {
        this.rc_img3 = rc_img3;
    }

    public Long getDe_userRegister() {
        return de_userRegister;
    }

    public void setDe_userRegister(Long de_userRegister) {
        this.de_userRegister = de_userRegister;
    }

    public Timestamp getDe_regiserDate() {
        return de_regiserDate;
    }

    public void setDe_regiserDate(Timestamp de_regiserDate) {
        this.de_regiserDate = de_regiserDate;
    }

    public Long getDe_userUpdate() {
        return de_userUpdate;
    }

    public void setDe_userUpdate(Long de_userUpdate) {
        this.de_userUpdate = de_userUpdate;
    }

    public Timestamp getDe_registerUpdate() {
        return de_registerUpdate;
    }

    public void setDe_registerUpdate(Timestamp de_registerUpdate) {
        this.de_registerUpdate = de_registerUpdate;
    }
}
