package com.web.apirelaciones.repository;

import com.web.apirelaciones.model.entity.Canciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionesRepository extends JpaRepository<Canciones, Integer> {
}
