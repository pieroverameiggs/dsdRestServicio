package com.restdsd.restservicio.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;

@Entity
@Table(name = "tb_tiposervicio")
public class TipoServicio implements Serializable {
    private static final long serialVersionUID = 7785487745482L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTipoServicio")
    private Long idtiposervicio;
    @Column(unique = true)
    private String ts_nombre;

    public Long getIdtiposervicio() {
        return idtiposervicio;
    }

    public void setIdtiposervicio(Long idtiposervicio) {
        this.idtiposervicio = idtiposervicio;
    }

    public String getTs_nombre() {
        return ts_nombre;
    }

    public void setTs_nombre(String ts_nobre) {
        this.ts_nombre = ts_nobre;
    }

}
