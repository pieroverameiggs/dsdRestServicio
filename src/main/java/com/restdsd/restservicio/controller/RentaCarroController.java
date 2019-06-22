package com.restdsd.restservicio.controller;


import com.restdsd.restservicio.entidades.RentaCarro;
import com.restdsd.restservicio.negocio.NegocioRentaCarro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RentaCarroController {
    @Autowired
    private NegocioRentaCarro negocioRentaCarro;
    Logger logger = LoggerFactory.getLogger(HotelController.class);

    @GetMapping("/rentacarros")
    public List<RentaCarro> listarRentaCarros(){
        return negocioRentaCarro.listaRentaCarros();
    }

    @PostMapping("/rentacarro")
    public RentaCarro crearRentaCarro(@RequestBody RentaCarro rentaCarro){
        RentaCarro rc;
        logger.debug("Creando Carro");
        rc = negocioRentaCarro.registrarRentaCarro(rentaCarro);
        return rc;
    }

    @PutMapping("/rentacarro")
    public RentaCarro actualizaRentaCarro(@RequestBody RentaCarro rentaCarro){
        RentaCarro rc;
        try {
            logger.debug("Actualizando Carro");
            rc = negocioRentaCarro.actualizaRentaCarro(rentaCarro);
        }catch (Exception e){
            logger.error("Error de actualización", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible realizar la actualización");
        }

        return rc;
    }

    @DeleteMapping("/rentacarro")
    public RentaCarro eliminaRentaCarro(@RequestBody RentaCarro rentaCarro){
        RentaCarro rc;
        try {
            logger.debug("Eliminando Carro");
            rc = negocioRentaCarro.borrarRentaCarro(rentaCarro.getIdrentacarro());
        }catch (Exception e){
            logger.error("Error de eliminacion", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible realizar la eliminacion");
        }

        return rc;
    }
}
