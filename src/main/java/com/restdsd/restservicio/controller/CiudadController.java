package com.restdsd.restservicio.controller;

import com.restdsd.restservicio.entidades.Ciudad;
import com.restdsd.restservicio.entidades.Pais;
import com.restdsd.restservicio.negocio.NegocioCiudad;
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
public class CiudadController {
    @Autowired
    private NegocioCiudad negocioCiudad;
    private NegocioPais negocioPais;

    Logger logger = LoggerFactory.getLogger(CiudadController.class);

    @GetMapping("/ciudades")
    public List<Ciudad> listarCiudades(){
        return negocioCiudad.listaCiudades();
    }

    @PostMapping("/ciudad")
    public Ciudad crearCiudad(@RequestBody Ciudad ciudad, @RequestParam(value="idPais") Long idpa){
        Ciudad c;
        try{
            logger.debug("Creando Ciudad");
            //logger.debug("El idPais es: " + ciudad.getPais().getIdpais().toString());
            Pais p = new Pais();
            logger.debug("idpais: " + idpa.toString());
            p.setIdpais(idpa);
            //p = negocioPais.obtenerPais(idpa);
            ciudad.setPais(p);

            c = negocioCiudad.registrarCiudad(ciudad);
        }catch (Exception e){
            logger.error("Error de grabado", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible realizar el grabado");
        }


        return c;
    }

    @PutMapping("/ciudad")
    public Ciudad actualizaCiudad(@RequestBody Ciudad ciudad){
        Ciudad c;
        try {
            logger.debug("Actualizando Ciudad");
            c = negocioCiudad.actualizaCiudad(ciudad);
        }catch (Exception e){
            logger.error("Error de actualización", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible realizar la actualización");
        }

        return c;
    }

    @DeleteMapping("/ciudad")
    public Ciudad eliminaCiudad(@RequestBody Ciudad ciudad){
        Ciudad c;
        try {
            logger.debug("Eliminando Ciudad");
            c = negocioCiudad.borrarCiudad(ciudad.getIdciudad());
        }catch (Exception e){
            logger.error("Error de eliminacion", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible realizar la eliminacion");
        }

        return c;
    }
}