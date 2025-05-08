package com.web.apirelaciones.model.dto.mapper;



import com.web.apirelaciones.model.dto.GeneroDTO;
import com.web.apirelaciones.model.entity.Genero;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface GeneroMapper {

    //GeneroMapper gm = Mappers.getMapper(GeneroMapper.class);

    //@Mapping(target = "idgenero", ignore = true)
    GeneroDTO GeneroToGeneroDTO(Genero genero);

    Genero GeneroDTOToGenero(GeneroDTO genDTO);

    List<GeneroDTO>  generosToGeneroDTOs(List<Genero> generos);




}
