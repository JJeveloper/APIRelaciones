package com.web.apirelaciones.repository;

import com.web.apirelaciones.model.entity.Cantantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CantantesRepository extends JpaRepository<Cantantes, Integer> {
}
