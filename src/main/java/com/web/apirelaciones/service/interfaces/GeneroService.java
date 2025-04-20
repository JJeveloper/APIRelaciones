package com.web.apirelaciones.service.interfaces;

import com.web.apirelaciones.model.dto.GeneroDTO;
import java.util.List;
import java.util.Optional;

public interface GeneroService {

    GeneroDTO crearGenero(GeneroDTO generoDTO);

    GeneroDTO actualizarGenero(Integer id, GeneroDTO generoDTO);

    List<GeneroDTO> mostrarTodosLosGeneros();

    Optional<GeneroDTO> buscarPorId(Integer id);

    void eliminarGeneroPorId(Integer id);

}
