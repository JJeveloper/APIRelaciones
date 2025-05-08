package com.web.apirelaciones.service.impl;

import com.web.apirelaciones.model.dto.CantantesCancionesDTO;
import com.web.apirelaciones.model.dto.CantantesDTO;
import com.web.apirelaciones.model.dto.mapper.CantantesCancionesMapper;
import com.web.apirelaciones.model.dto.mapper.CantantesMapper;
import com.web.apirelaciones.model.entity.Cantantes;
import com.web.apirelaciones.repository.CantantesRepository;
import com.web.apirelaciones.service.interfaces.CantantesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CantantesServiceImpl implements CantantesService {

    private CantantesRepository cantanteRepository;
    private CantantesMapper cantantesMapper;
    private CantantesCancionesMapper cantantesCancionesMapper;

    public CantantesServiceImpl(CantantesRepository cantanteRepository, CantantesMapper cantantesMapper, CantantesCancionesMapper cantantesCancionesMapper) {
        this.cantanteRepository = cantanteRepository;
        this.cantantesMapper = cantantesMapper;
        this.cantantesCancionesMapper = cantantesCancionesMapper;
    }

    @Override
    public CantantesDTO crearCantante(CantantesDTO cantantesDTO) {

        Cantantes nuevoCantante = cantantesMapper.cantantesDTOTOCantantes(cantantesDTO);

        Cantantes cantanteCreado = cantanteRepository.save(nuevoCantante);

        return cantantesMapper.cantastesTOCantantesDTO(cantanteCreado);
    }

    @Override
    public CantantesDTO actualizarCantante(Integer id, CantantesDTO cantantesDTO) {

        Cantantes actualizarCantante = cantantesMapper.cantantesDTOTOCantantes(cantantesDTO);

        if (cantanteRepository.findById(id).isEmpty()) {
            System.out.println("Cantante no encontrado: " + id);
            return null;
        }

        actualizarCantante.setIdcantante(id);
        cantanteRepository.save(actualizarCantante);
        CantantesDTO cantanteActualizado = cantantesMapper.cantastesTOCantantesDTO(actualizarCantante);

        return cantanteActualizado;
    }

    @Override
    public List<CantantesDTO> mostrarTodosLosCantantes() {
        List<Cantantes> liste = cantanteRepository.findAll();
        List<CantantesDTO> cantantesDTOs = cantantesMapper.cantantesTOCantantesDTOs(liste);
        return cantantesDTOs;
    }

    @Override
    public Optional<CantantesCancionesDTO> buscarCantantePorId(Integer id) {

        Optional<Cantantes> cantanteOptional = cantanteRepository.findById(id);

        if (cantanteOptional.isEmpty()) {
            System.out.println("Cantante no econtrado con id: " + id);
            return null;
        }

        CantantesCancionesDTO cantanteDTO = cantantesCancionesMapper.cantantesCancionesDTOTOCantantes(cantanteOptional.get());
        Optional<CantantesCancionesDTO> cantanteDTOOptional = Optional.ofNullable(cantanteDTO);

        return cantanteDTOOptional;

    }

    @Override
    public void eliminarCantantePorId(Integer id) {

        if (!cantanteRepository.existsById(id)) {
            System.out.println("Cantante no encontrado con id: " + id);
        } else {
            cantanteRepository.deleteById(id);
        }


    }

}
