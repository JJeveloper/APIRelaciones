package com.web.apirelaciones.service.interfaces;

import com.web.apirelaciones.model.dto.CantantesCancionesDTO;
import com.web.apirelaciones.model.dto.CantantesDTO;

import java.util.List;
import java.util.Optional;

public interface CantantesService {

    CantantesDTO crearCantante(CantantesDTO cantantesDTO);

    CantantesDTO actualizarCantante(Integer id, CantantesDTO cantantesDTO);

    List<CantantesDTO> mostrarTodosLosCantantes();

    Optional<CantantesCancionesDTO> buscarCantantePorId(Integer id);

    void eliminarCantantePorId(Integer id);

}
