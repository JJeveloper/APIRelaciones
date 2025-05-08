package com.web.apirelaciones.service.impl;

import com.web.apirelaciones.model.dto.CancionesDTO;
import com.web.apirelaciones.model.dto.CancionesRelacionDTO;
import com.web.apirelaciones.model.dto.mapper.CancionesMapper;
import com.web.apirelaciones.model.dto.mapper.CancionesRelacionMapper;
import com.web.apirelaciones.model.entity.Canciones;
import com.web.apirelaciones.model.entity.Cantantes;
import com.web.apirelaciones.model.entity.Genero;
import com.web.apirelaciones.repository.CancionesRepository;
import com.web.apirelaciones.repository.CantantesRepository;
import com.web.apirelaciones.repository.GeneroRepository;
import com.web.apirelaciones.service.interfaces.CancionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CancionesServiceImpl implements CancionesService {

    private CancionesRepository cancionesRepository;
    private GeneroRepository generoRepository;
    private CantantesRepository cantantesRepository;
    private CancionesMapper cancionesMapper;
    private CancionesRelacionMapper cancionesRelacionMapper;

    @Autowired
    public CancionesServiceImpl(CancionesRepository cancionesRepository, GeneroRepository generoRepository, CantantesRepository cantantesRepository, CancionesMapper cancionesMapper, CancionesRelacionMapper cancionesRelacionMapper) {
        this.cancionesRepository = cancionesRepository;
        this.generoRepository = generoRepository;
        this.cantantesRepository = cantantesRepository;
        this.cancionesMapper = cancionesMapper;
        this.cancionesRelacionMapper = cancionesRelacionMapper;
    }

    @Override
    public CancionesDTO crearCanciones(CancionesDTO cancionesDTO) {

        //Obtener id del genero y del cantante
        Genero generoId = generoRepository.findById(cancionesDTO.getIdgenero()).get();
        Cantantes cantanteId = cantantesRepository.findById(cancionesDTO.getIdcantante()).get();

        Canciones nuevaCancion = cancionesMapper.cancionesDTOTOCanciones(cancionesDTO);

        nuevaCancion.setGenero(generoId);
        nuevaCancion.setCantantes(cantanteId);;

        Canciones cancionGuardada = cancionesRepository.save(nuevaCancion);

        return cancionesMapper.cancionesTOCancionesDTO(cancionGuardada);
    }

    @Override
    public CancionesDTO actualizarCantante(Integer id, CancionesDTO cancionesDTO) {

        if (!cancionesRepository.existsById(id)){
            System.out.println("Cancion no encontrado con ID: " + id);
            return null;
        }

        Canciones actualizarCancion = cancionesMapper.cancionesDTOTOCanciones(cancionesDTO);


        Genero generoId = generoRepository.findById(cancionesDTO.getIdgenero()).orElse(null);
        Cantantes cantanteId = cantantesRepository.findById(cancionesDTO.getIdcantante()).orElse(null);

        if (generoId==null || cantanteId ==null){
            return null;
        }

        actualizarCancion.setIdcancion(id);
        actualizarCancion.setGenero(generoId);
        actualizarCancion.setCantantes(cantanteId);


        cancionesRepository.save(actualizarCancion);

        CancionesDTO cancionActualizada = cancionesMapper.cancionesTOCancionesDTO(actualizarCancion);

        return cancionActualizada;
    }

    @Override
    public List<CancionesDTO> mostrarTodasLasCanciones() {
        List<Canciones>  canciones = cancionesRepository.findAll();
        List<CancionesDTO> cancionesDTOList = cancionesMapper.canionesTOCancionesDTOs(canciones);
        return cancionesDTOList;
    }

    @Override
    public Optional<CancionesRelacionDTO> buscarCancionPorId(Integer id) {

        Optional<Canciones> cancionesOptional = cancionesRepository.findById(id);

        if (cancionesOptional.isEmpty()){
            System.out.println("Cancion no econtrada con id: " + id);
            return null;
        }

        CancionesRelacionDTO cancionesDTO = cancionesRelacionMapper.cancionesRelacionDTOTOCanciones(cancionesOptional.get());
        Optional<CancionesRelacionDTO> cancionesDTOOptional = Optional.ofNullable(cancionesDTO);

        return cancionesDTOOptional;
    }

    @Override
    public void eliminarCancionPorId(Integer id) {

        Optional<Canciones> cancionesOptional = cancionesRepository.findById(id);

        if (cancionesOptional.isEmpty()){
            System.out.println("Cancion no econtrada con id: " + id);
        }else{
            cancionesRepository.deleteById(id);
        }


    }
}
