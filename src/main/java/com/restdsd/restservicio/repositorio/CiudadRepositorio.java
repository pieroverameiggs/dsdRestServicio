package com.restdsd.restservicio.repositorio;

import com.restdsd.restservicio.entidades.Ciudad;
import org.springframework.data.repository.CrudRepository;

public interface CiudadRepositorio extends CrudRepository<Ciudad, Long> {
}
