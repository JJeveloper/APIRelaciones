package com.web.apirelaciones.model.dto.mapper;

import com.web.apirelaciones.model.dto.CancionesResumenDTO;
import com.web.apirelaciones.model.dto.CantantesCancionesDTO;
import com.web.apirelaciones.model.entity.Canciones;
import com.web.apirelaciones.model.entity.Cantantes;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CantantesCancionesMapper {

    CantantesCancionesDTO cantantesCancionesDTOTOCantantes(Cantantes cantantes);

    List<CantantesCancionesDTO> CantantesCancionesDTOListTOCAntantes(List<Cantantes> cantantes);

    CancionesResumenDTO CancionesResumenDTOTOCanciones(Canciones canciones);


}
