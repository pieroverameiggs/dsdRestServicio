package com.restdsd.restservicio.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;

@Entity
@Table(name = "tb_tarifario")
public class Tarifario implements Serializable {
    private static final long serialVersionUID = 2381937198246L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTarifario")
    private Long idtarifario;
    @ManyToOne
    @JoinColumn(name = "IdTipoServicio")
    @JsonIgnore
    private TipoServicio ta_tiposervicio;
    private Long ta_idregistroservicio;
    private Long ta_idproveedor;
    private Double ta_precio;
    private Long de_userRegister;
    private Timestamp de_regiserDate;
    private Long de_userUpdate;
    private Timestamp de_registerUpdate;

    public Long getIdtarifario() {
        return idtarifario;
    }

    public void setIdtarifario(Long idtarifario) {
        this.idtarifario = idtarifario;
    }

    public TipoServicio getTa_tiposervicio() {
        return ta_tiposervicio;
    }

    public void setTa_tiposervicio(TipoServicio ta_tiposervicio) {
        this.ta_tiposervicio = ta_tiposervicio;
    }

    public Long getTa_idregistroservicio() {
        return ta_idregistroservicio;
    }

    public void setTa_idregistroservicio(Long ta_idregistroservicio) {
        this.ta_idregistroservicio = ta_idregistroservicio;
    }

    public Long getTa_idproveedor() {
        return ta_idproveedor;
    }

    public void setTa_idproveedor(Long ta_idproveedor) {
        this.ta_idproveedor = ta_idproveedor;
    }

    public Double getTa_precio() {
        return ta_precio;
    }

    public void setTa_precio(Double ta_precio) {
        this.ta_precio = ta_precio;
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
