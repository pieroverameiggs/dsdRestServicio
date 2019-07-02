package com.restdsd.restservicio.negocio;

import com.restdsd.restservicio.entidades.Hotel;
import com.restdsd.restservicio.repositorio.HotelRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NegocioHotel {
    @Autowired
    private HotelRepositorio hotelRepositorio;

    public Hotel registrarHotel(Hotel hotel){
        return hotelRepositorio.save(hotel);
    }

    public List<Hotel> listaHoteles(){
        return (List<Hotel>)hotelRepositorio.findAll();
    }

    public Hotel actualizaHotel(Hotel hotel) throws Exception{
        Hotel h = hotelRepositorio.findById(hotel.getIdhotel()).orElseThrow(() -> new Exception("No existe el hotel"));

        h.setDestino(hotel.getDestino());
        h.setHo_titulo(hotel.getHo_titulo());
        h.setHo_descripcioncorta(hotel.getHo_descripcioncorta());
        h.setHo_descripcionlarga(hotel.getHo_descripcionlarga());
        h.setHo_img1(hotel.getHo_img1());
        h.setHo_img2(hotel.getHo_img2());
        h.setHo_img3(hotel.getHo_img3());
        h.setHo_estrellas(hotel.getHo_estrellas());

        return hotelRepositorio.save(h);
    }

    public Hotel borrarHotel(Long codigo) throws Exception{
        Hotel h = hotelRepositorio.findById(codigo).orElseThrow(() -> new Exception("No existe el hotel"));
        hotelRepositorio.delete(h);
        return  h;
    }
}
