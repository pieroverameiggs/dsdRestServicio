package com.restdsd.restservicio.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.List;

@Entity
@Table(name = "tb_hotel")
public class Hotel implements Serializable {
    private static final long serialVersionUID = 1110252012365L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdHotel")
    private Long idhotel;
    @ManyToOne
    @JoinColumn(name = "IdDestino")
    @JsonIgnore
    private Destino destino;
    private String ho_titulo;
    private String ho_descripcioncorta;
    private String ho_descripcionlarga;
    private String ho_img1;
    private String ho_img2;
    private String ho_img3;
    private int ho_estrellas;
    private Long de_userRegister;
    private Timestamp de_regiserDate;
    private Long de_userUpdate;
    private Timestamp de_registerUpdate;

    public Long getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(Long idhotel) {
        this.idhotel = idhotel;
    }

    public String getHo_titulo() {
        return ho_titulo;
    }

    public void setHo_titulo(String ho_titulo) {
        this.ho_titulo = ho_titulo;
    }

    public String getHo_descripcioncorta() {
        return ho_descripcioncorta;
    }

    public void setHo_descripcioncorta(String ho_descripcioncorta) {
        this.ho_descripcioncorta = ho_descripcioncorta;
    }

    public String getHo_descripcionlarga() {
        return ho_descripcionlarga;
    }

    public void setHo_descripcionlarga(String ho_descripcionlarga) {
        this.ho_descripcionlarga = ho_descripcionlarga;
    }

    public String getHo_img1() {
        return ho_img1;
    }

    public void setHo_img1(String ho_img1) {
        this.ho_img1 = ho_img1;
    }

    public String getHo_img2() {
        return ho_img2;
    }

    public void setHo_img2(String ho_img2) {
        this.ho_img2 = ho_img2;
    }

    public String getHo_img3() {
        return ho_img3;
    }

    public void setHo_img3(String ho_img3) {
        this.ho_img3 = ho_img3;
    }

    public int getHo_estrellas() {
        return ho_estrellas;
    }

    public void setHo_estrellas(int ho_estrellas) {
        this.ho_estrellas = ho_estrellas;
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

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

}
