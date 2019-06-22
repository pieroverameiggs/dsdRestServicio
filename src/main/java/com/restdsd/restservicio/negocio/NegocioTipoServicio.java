package com.restdsd.restservicio.negocio;

import com.restdsd.restservicio.entidades.TipoServicio;
import com.restdsd.restservicio.repositorio.TipoServicioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NegocioTipoServicio {
    @Autowired
    private TipoServicioRepositorio tipoServicioRepositorio;

    public TipoServicio crearTipoServicio(TipoServicio tipoServicio){

        return tipoServicioRepositorio.save(tipoServicio);
    }

    public List<TipoServicio> listaTipoServicio(){

        return (List<TipoServicio>) tipoServicioRepositorio.findAll();
    }

    public TipoServicio actualizaTipoServicio(TipoServicio tipoServicio) throws Exception{
        TipoServicio ts = tipoServicioRepositorio.findById(tipoServicio.getIdtiposervicio()).orElseThrow(() -> new Exception("No existe el Tipo de Servicio"));

        ts.setTs_nombre(tipoServicio.getTs_nombre());
        return tipoServicioRepositorio.save(ts);
    }

    public TipoServicio borrarTipoServicio(Long codigo) throws Exception{
        TipoServicio ts = tipoServicioRepositorio.findById(codigo).orElseThrow(() -> new Exception("No existe el Tipo de Servicio"));
        tipoServicioRepositorio.delete(ts);
        return  ts;
    }
}
