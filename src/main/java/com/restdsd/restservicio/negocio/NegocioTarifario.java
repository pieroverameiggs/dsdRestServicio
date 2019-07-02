package com.restdsd.restservicio.negocio;

import com.restdsd.restservicio.entidades.Tarifario;
import com.restdsd.restservicio.repositorio.TarifarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NegocioTarifario {
    @Autowired
    private TarifarioRepositorio tarifarioRepositorio;

    public Tarifario registrarTarifario(Tarifario tarifario){
        return tarifarioRepositorio.save(tarifario);
    }

    public List<Tarifario> listaTarifario(){
        return (List<Tarifario>)tarifarioRepositorio.findAll();
    }

    public Tarifario actualizaTarifario(Tarifario tarifario) throws Exception{
        Tarifario t = tarifarioRepositorio.findById(tarifario.getIdtarifario()).orElseThrow(() -> new Exception("No existe tarifa"));

        t.setTa_idtiposervicio(tarifario.getTa_idtiposervicio());
        t.setTa_idregistroservicio(tarifario.getTa_idregistroservicio());
        t.setTa_idproveedor(tarifario.getTa_idproveedor());
        t.setTa_precio(tarifario.getTa_precio());

        return tarifarioRepositorio.save(t);
    }

    public Tarifario borrarTarifario(Long codigo) throws Exception{
        Tarifario t = tarifarioRepositorio.findById(codigo).orElseThrow(() -> new Exception("No existe tarifa"));
        tarifarioRepositorio.delete(t);
        return t;
    }

}
