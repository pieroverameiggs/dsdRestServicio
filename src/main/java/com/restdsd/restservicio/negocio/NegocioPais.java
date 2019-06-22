package com.restdsd.restservicio.negocio;

import com.restdsd.restservicio.entidades.Pais;
import com.restdsd.restservicio.repositorio.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NegocioPais {
    @Autowired
    private PaisRepositorio paisRepositorio;

    public Pais crearPais(Pais pais){
        return paisRepositorio.save(pais);
    }

    public List<Pais> listaPais(){
        return (List<Pais>) paisRepositorio.findAll();
    }

    public Pais obtenerPais(Long codigo) throws Exception{
        return paisRepositorio.findById(codigo).orElseThrow(() -> new Exception("No existe el Pais"));
    }

    public Pais actualizaPais(Pais pais) throws Exception{
        Pais p = paisRepositorio.findById(pais.getIdpais()).orElseThrow(() -> new Exception("No existe el Pais"));

        p.setPa_nombre(pais.getPa_nombre());
        return paisRepositorio.save(p);
    }

    public Pais borrarPais(Long codigo) throws Exception{
        Pais p = paisRepositorio.findById(codigo).orElseThrow(() -> new Exception("No existe el Pais"));
        paisRepositorio.delete(p);
        return  p;
    }
}
