package com.web.apirelaciones.model.dto.mapper;

import com.web.apirelaciones.model.dto.CancionesDTO;
import com.web.apirelaciones.model.entity.Canciones;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CancionesMapper {

    @Mapping(source = "cantantes.idcantante", target = "idcantante")
    @Mapping(source = "genero.idgenero", target = "idgenero")
    CancionesDTO cancionesTOCancionesDTO(Canciones canciones);

    Canciones cancionesDTOTOCanciones(CancionesDTO cancionesDTO);

    List<CancionesDTO> canionesTOCancionesDTOs(List<Canciones> canciones);

}
