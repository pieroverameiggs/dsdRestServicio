package com.restdsd.restservicio.controller;


import com.restdsd.restservicio.entidades.Ciudad;
import com.restdsd.restservicio.entidades.Destino;
import com.restdsd.restservicio.entidades.Pais;
import com.restdsd.restservicio.negocio.NegocioDestino;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DestinoController {
    @Autowired
    private NegocioDestino negocioDestino;
    Logger logger = LoggerFactory.getLogger(DestinoController.class);

    @GetMapping("/destinos")
    public List<Destino> listarDestinos(){
        return negocioDestino.listaDestinos();
    }

    @PostMapping("/destino")
    public Destino crearDestino(@RequestBody Destino destino, @RequestParam(value="idPais") Long idpa, @RequestParam(value="idCiudad") Long idciu){
        Destino d;
        Pais p = new Pais();
        p.setIdpais(idpa);

        Ciudad c = new Ciudad();
        c.setIdciudad(idciu);

        logger.debug("Creando Destino");
        destino.setDe_pais(p);
        destino.setDe_ciudad(c);

        d = negocioDestino.registrarDestino(destino);
        return d;
    }

    @PutMapping("/destino")
    public Destino actualizaDestino(@RequestBody Destino destino){
        Destino d;
        try {
            logger.debug("Actualizando Destino");
            d = negocioDestino.actualizaDestino(destino);
        }catch (Exception e){
            logger.error("Error de actualización", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible realizar la actualización");
        }

        return d;
    }

    @DeleteMapping("/destino")
    public Destino eliminaDestino(@RequestBody Destino destino){
        Destino d;
        try {
            logger.debug("Eliminando Destino");
            d = negocioDestino.borrarDestino(destino.getIddestino());
        }catch (Exception e){
            logger.error("Error de eliminacion", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible realizar la eliminacion");
        }

        return d;
    }
}
