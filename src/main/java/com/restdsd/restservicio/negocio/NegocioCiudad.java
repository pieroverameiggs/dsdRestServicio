package com.restdsd.restservicio.negocio;

import com.restdsd.restservicio.entidades.Ciudad;
import com.restdsd.restservicio.entidades.Pais;
import com.restdsd.restservicio.repositorio.CiudadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NegocioCiudad {
    @Autowired
    private CiudadRepositorio ciudadRepositorio;

    public Ciudad registrarCiudad(Pais pais, Ciudad ciudad){
        ciudad.setCi_pais(pais);
        return ciudadRepositorio.save(ciudad);
    }

    public List<Ciudad> listaCiudades(){
        return (List<Ciudad>)ciudadRepositorio.findAll();
    }

    public Ciudad actualizaCiudad(Ciudad ciudad) throws Exception{
        Long idCiudad = ciudad.getIdciudad();
        Ciudad c = ciudadRepositorio.findById(idCiudad).orElseThrow(() -> new Exception("No existe la ciudad"));

        c.setCi_pais(ciudad.getCi_pais());
        c.setCi_nombre(ciudad.getCi_nombre());
        return ciudadRepositorio.save(c);
    }

    public Ciudad borrarCiudad(Long codigo) throws Exception{
        Ciudad p = ciudadRepositorio.findById(codigo).orElseThrow(() -> new Exception("No existe la ciudad"));
        ciudadRepositorio.delete(p);
        return  p;
    }
}
