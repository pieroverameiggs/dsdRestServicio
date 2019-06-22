package com.restdsd.restservicio.controller;

import com.restdsd.restservicio.entidades.TipoServicio;
import com.restdsd.restservicio.negocio.NegocioTipoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoServicioController {
    @Autowired
    private NegocioTipoServicio negocioTipoServicio;
    Logger logger = LoggerFactory.getLogger(TipoServicioController.class);

    @GetMapping("/tiposervicios")
    public List<TipoServicio> listarTipoServicios(){
        return negocioTipoServicio.listaTipoServicio();
    }

    @PostMapping("/tiposervicio")
    public TipoServicio crearPais(@RequestBody TipoServicio tipoServicio){
        TipoServicio ts;
        logger.debug("Creando Tipo Servicio");
        ts = negocioTipoServicio.crearTipoServicio(tipoServicio);
        return ts;
    }

    @PutMapping("/tiposervicio")
    public TipoServicio actualizaTipoServicio(@RequestBody TipoServicio tipoServicio){
        TipoServicio ts;
        try {
            logger.debug("Actualizando Tipo Servicio");
            ts = negocioTipoServicio.actualizaTipoServicio(tipoServicio);
        }catch (Exception e){
            logger.error("Error de actualización", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible realizar la actualización");
        }

        return ts;
    }

    @DeleteMapping("/tiposervicio")
    public TipoServicio eliminaTipoServicio(@RequestBody TipoServicio tipoServicio){
        TipoServicio ts;
        try {
            logger.debug("Eliminando Tipo Servicio");
            ts = negocioTipoServicio.borrarTipoServicio(tipoServicio.getIdtiposervicio());
        }catch (Exception e){
            logger.error("Error de eliminacion", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible realizar la eliminacion");
        }

        return ts;
    }

}
