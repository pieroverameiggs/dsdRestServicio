package com.restdsd.restservicio.repositorio;

import com.restdsd.restservicio.entidades.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepositorio extends CrudRepository<Hotel, Long> {
}
