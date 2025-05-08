package com.web.apirelaciones.service.interfaces;

import com.web.apirelaciones.model.dto.CancionesDTO;
import com.web.apirelaciones.model.dto.CancionesRelacionDTO;

import java.util.List;
import java.util.Optional;

public interface CancionesService {

    CancionesDTO crearCanciones(CancionesDTO cancionesDTO);

    CancionesDTO actualizarCantante(Integer id, CancionesDTO cancionesDTO);

    List<CancionesDTO> mostrarTodasLasCanciones();

    Optional<CancionesRelacionDTO> buscarCancionPorId(Integer id);

    void eliminarCancionPorId(Integer id);
}
