package com.restdsd.restservicio.repositorio;

import com.restdsd.restservicio.entidades.Pais;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PaisRepositorio extends CrudRepository<Pais, Long> {

}
