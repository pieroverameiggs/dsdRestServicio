package com.restdsd.restservicio.negocio;

import com.restdsd.restservicio.entidades.RentaCarro;
import com.restdsd.restservicio.repositorio.RentaCarroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NegocioRentaCarro {
    @Autowired
    private RentaCarroRepositorio rentaCarroRepositorio;


    public RentaCarro registrarRentaCarro(RentaCarro rentaCarro){
        return rentaCarroRepositorio.save(rentaCarro);
    }

    public List<RentaCarro> listaRentaCarros(){
        return (List<RentaCarro>)rentaCarroRepositorio.findAll();
    }

    public RentaCarro actualizaRentaCarro(RentaCarro rentaCarro) throws Exception{
        RentaCarro rc = rentaCarroRepositorio.findById(rentaCarro.getIdrentacarro()).orElseThrow(() -> new Exception("No existe el Carro"));

        rc.setRc_destinos(rentaCarro.getRc_destinos());
        rc.setRc_titulo(rentaCarro.getRc_titulo());
        rc.setRc_descripcioncorta(rentaCarro.getRc_descripcioncorta());
        rc.setRc_descripcionlarga(rentaCarro.getRc_descripcionlarga());
        rc.setRc_img1(rentaCarro.getRc_img1());
        rc.setRc_img2(rentaCarro.getRc_img2());
        rc.setRc_img3(rentaCarro.getRc_img3());

        return rentaCarroRepositorio.save(rc);
    }

    public RentaCarro borrarRentaCarro(Long codigo) throws Exception{
        RentaCarro rc = rentaCarroRepositorio.findById(codigo).orElseThrow(() -> new Exception("No existe el Carro"));
        rentaCarroRepositorio.delete(rc);
        return  rc;
    }
}
