package com.restdsd.restservicio.negocio;

import com.restdsd.restservicio.entidades.Destino;
import com.restdsd.restservicio.repositorio.DestinoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NegocioDestino {
    @Autowired
    private DestinoRepositorio destinoRepositorio;

    public Destino registrarDestino(Destino destino){
        return destinoRepositorio.save(destino);
    }

    public List<Destino> listaDestinos(){
        return (List<Destino>)destinoRepositorio.findAll();
    }

    public Destino actualizaDestino(Destino destino) throws Exception{
        Destino d = destinoRepositorio.findById(destino.getIddestino()).orElseThrow(() -> new Exception("No existe el destino"));

        d.setDe_ciudad(destino.getDe_ciudad());
        d.setDe_pais(destino.getDe_pais());
        d.setDe_titprincipal(destino.getDe_titprincipal());
        d.setDe_titpequenho(destino.getDe_titpequenho());
        d.setDe_descripcioncorta(destino.getDe_descripcioncorta());
        d.setDe_descripcionlarga(destino.getDe_descripcionlarga());
        d.setDe_img1(destino.getDe_img1());
        d.setDe_img2(destino.getDe_img2());
        d.setDe_img3(destino.getDe_img3());
        d.setDe_vecesutilizado(destino.getDe_vecesutilizado());
        d.setDe_googlemaps(destino.getDe_googlemaps());

        return destinoRepositorio.save(d);
    }

    public Destino borrarDestino(Long codigo) throws Exception{
        Destino d = destinoRepositorio.findById(codigo).orElseThrow(() -> new Exception("No existe el destino"));
        destinoRepositorio.delete(d);
        return  d;
    }

}
