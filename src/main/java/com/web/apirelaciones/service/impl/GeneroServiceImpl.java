package com.web.apirelaciones.service.impl;

import com.web.apirelaciones.model.dto.GeneroDTO;
import com.web.apirelaciones.model.dto.mapper.GeneroMapper;
import com.web.apirelaciones.model.entity.Genero;
import com.web.apirelaciones.repository.GeneroRepository;
import com.web.apirelaciones.service.interfaces.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroServiceImpl implements GeneroService {


    private final GeneroRepository generoRepository;
    private final GeneroMapper generoMapper;

    @Autowired
    public GeneroServiceImpl(GeneroRepository generoRepository, GeneroMapper generoMapper) {
        this.generoRepository = generoRepository;
        this.generoMapper = generoMapper;
    }

    @Override
    public GeneroDTO crearGenero(GeneroDTO generoDTO) {

        Genero nuevogenero = generoMapper.GeneroDTOToGenero(generoDTO);

        Genero GeneroGuardado = generoRepository.save(nuevogenero);

        return generoMapper.GeneroToGeneroDTO(GeneroGuardado);
    }

    @Override
    public GeneroDTO actualizarGenero(Integer id, GeneroDTO generoDTO) {

        Genero actualizargenero = generoMapper.GeneroDTOToGenero(generoDTO);

        if (!generoRepository.existsById(id)){
            System.out.println("Genero no encontrado con ID: " + id);
            return null;
        }else{

            actualizargenero.setIdgenero(id);
            generoRepository.save(actualizargenero);

            GeneroDTO generoActulizado = generoMapper.GeneroToGeneroDTO(actualizargenero);
            return generoActulizado;
        }

    }

    @Override
    public List<GeneroDTO> mostrarTodosLosGeneros() {
        List<Genero> list = generoRepository.findAll();
        return generoMapper.generosToGeneroDTOs(list);
    }

    @Override
    public Optional<GeneroDTO> buscarPorId(Integer id) {

        Optional<Genero> GeneroOptional = generoRepository.findById(id);

        if(GeneroOptional.isEmpty()){
            System.out.println("Genero no encontrado con ID: " + id);
            return Optional.empty();
        }

        GeneroDTO generoDTO = generoMapper.GeneroToGeneroDTO(GeneroOptional.get());
        Optional<GeneroDTO> generoDTOOptional = GeneroOptional.ofNullable(generoDTO) ;

        return generoDTOOptional;

    }

    @Override
    public void eliminarGeneroPorId(Integer id) {

        if(!generoRepository.existsById(id)){
            System.out.println("Genero no encontrado con ID: " + id);
        }else {

            generoRepository.deleteById(id);

        }

    }

}
