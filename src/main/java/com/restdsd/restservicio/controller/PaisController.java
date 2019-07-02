package com.restdsd.restservicio.controller;

import com.restdsd.restservicio.entidades.Pais;
import com.restdsd.restservicio.negocio.NegocioPais;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaisController {
    @Autowired
    private NegocioPais negocioPais;
    Logger logger = LoggerFactory.getLogger(PaisController.class);



    @GetMapping("/paises")
    public List<Pais> listarPaises(){
        return negocioPais.listaPais();
    }

    @GetMapping("/pais")
    public Pais consultaPais(@RequestParam(value="idPais") Long idpa){
        Pais p;
        try{
            p = negocioPais.obtenerPais(idpa);
        }catch (Exception e)
        {
            logger.error("Error de busqueda", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible encontrar el pais");
        }

        return p;
    }

    @PostMapping("/pais")
    public Pais crearPais(@RequestBody Pais pais){
        Pais p;
        logger.debug("Creando Pais");
        p = negocioPais.crearPais(pais);
        return p;
    }

    @PutMapping("/pais")
    public Pais actualizaPais(@RequestBody Pais pais){
        Pais p;
        try {
            logger.debug("Actualizando Pais");
            p = negocioPais.actualizaPais(pais);
        }catch (Exception e){
            logger.error("Error de actualización", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible realizar la actualización");
        }

        return p;
    }

    @DeleteMapping("/pais")
    public Pais eliminaPais(@RequestBody Pais pais){
        Pais p;
        try {
            logger.debug("Eliminando Pais");
            p = negocioPais.borrarPais(pais.getIdpais());
        }catch (Exception e){
            logger.error("Error de eliminacion", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible realizar la eliminacion");
        }

        return p;
    }
}
