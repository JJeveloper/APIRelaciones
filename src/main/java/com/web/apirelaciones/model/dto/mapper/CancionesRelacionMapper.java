package com.web.apirelaciones.model.dto.mapper;

import com.web.apirelaciones.model.dto.CancionesRelacionDTO;
import com.web.apirelaciones.model.dto.CantantesDTO;
import com.web.apirelaciones.model.dto.GeneroDTO;
import com.web.apirelaciones.model.entity.Canciones;
import com.web.apirelaciones.model.entity.Cantantes;
import com.web.apirelaciones.model.entity.Genero;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CancionesRelacionMapper {

    CancionesRelacionDTO cancionesRelacionDTOTOCanciones(Canciones canciones);

    List<CancionesRelacionDTO> cancionesRelacionDTOListTOCanciones(List<Canciones> canciones);

    CantantesDTO cantantesDTOTOCantantes(Cantantes cantantes);

    GeneroDTO generoDTOTOGenero(Genero genero);
}
