package com.web.apirelaciones.model.dto.mapper;

//import com.web.apirelaciones.model.dto.CantantesCancionesDTO;
import com.web.apirelaciones.model.dto.CantantesDTO;
import com.web.apirelaciones.model.entity.Cantantes;
import com.web.apirelaciones.model.entity.Genero;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CantantesMapper {


    CantantesDTO cantastesTOCantantesDTO(Cantantes cantantes);

    Cantantes cantantesDTOTOCantantes(CantantesDTO cantantesDTO);

    List<CantantesDTO> cantantesTOCantantesDTOs(List<Cantantes> cantantes);

}
