package com.restdsd.restservicio.controller;

import com.restdsd.restservicio.entidades.Tarifario;
import com.restdsd.restservicio.negocio.NegocioTarifario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TarifarioController {
    @Autowired
    private NegocioTarifario negocioTarifario;
    Logger logger = LoggerFactory.getLogger(HotelController.class);

    @GetMapping("/tarifarios")
    public List<Tarifario> listarTarifarios(){
        return negocioTarifario.listaTarifario();
    }

    @PostMapping("/tarifario")
    public Tarifario crearTarifario(@RequestBody Tarifario tarifario){
        Tarifario t;
        logger.debug("Creando Tarifario");
        t = negocioTarifario.registrarTarifario(tarifario);
        return t;
    }

    @PutMapping("/tarifario")
    public Tarifario actualizaRentaCarro(@RequestBody Tarifario tarifario){
        Tarifario t;
        try {
            logger.debug("Actualizando Tarifario");
            t = negocioTarifario.actualizaTarifario(tarifario);
        }catch (Exception e){
            logger.error("Error de actualización", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible realizar la actualización");
        }

        return t;
    }

    @DeleteMapping("/tarifario")
    public Tarifario eliminaTarifario(@RequestBody Tarifario tarifario){
        Tarifario t;
        try {
            logger.debug("Eliminando Tarifario");
            t = negocioTarifario.borrarTarifario(tarifario.getIdtarifario());
        }catch (Exception e){
            logger.error("Error de eliminacion", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible realizar la eliminacion");
        }

        return t;
    }
}
