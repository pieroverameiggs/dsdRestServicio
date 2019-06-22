package com.restdsd.restservicio.controller;

import com.restdsd.restservicio.entidades.Hotel;
import com.restdsd.restservicio.negocio.NegocioHotel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelController {
    @Autowired
    private NegocioHotel negocioHotel;
    Logger logger = LoggerFactory.getLogger(HotelController.class);

    @GetMapping("/hoteles")
    public List<Hotel> listarhoteles(){
        return negocioHotel.listaHoteles();
    }

    @PostMapping("/hotel")
    public Hotel crearHotel(@RequestBody Hotel hotel){
        Hotel h;
        logger.debug("Creando Hotel");
        h = negocioHotel.registrarHotel(hotel);
        return h;
    }

    @PutMapping("/hotel")
    public Hotel actualizaHotel(@RequestBody Hotel hotel){
        Hotel h;
        try {
            logger.debug("Actualizando Hotel");
            h = negocioHotel.actualizaHotel(hotel);
        }catch (Exception e){
            logger.error("Error de actualización", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible realizar la actualización");
        }

        return h;
    }

    @DeleteMapping("/hotel")
    public Hotel eliminaHotel(@RequestBody Hotel hotel){
        Hotel h;
        try {
            logger.debug("Eliminando Hotel");
            h = negocioHotel.borrarHotel(hotel.getIdhotel());
        }catch (Exception e){
            logger.error("Error de eliminacion", e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible realizar la eliminacion");
        }

        return h;
    }
}
