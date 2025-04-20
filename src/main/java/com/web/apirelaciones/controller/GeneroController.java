package com.web.apirelaciones.controller;

import com.web.apirelaciones.model.dto.GeneroDTO;
import com.web.apirelaciones.service.interfaces.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genero/")
public class GeneroController {

    private final GeneroService generoServicio;

    @Autowired
    public GeneroController(GeneroService generoServicio) {
        this.generoServicio = generoServicio;
    }

    @PostMapping("creargenero")
    public ResponseEntity<GeneroDTO> crearGenero(@RequestBody GeneroDTO generoDTO){
        GeneroDTO crearGenero = generoServicio.crearGenero(generoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(crearGenero);
    }

    @PutMapping("actualizargenero/{id}")
    public ResponseEntity<GeneroDTO> actualizargenero(@PathVariable("id") Integer id, @RequestBody GeneroDTO generoDTO){

        GeneroDTO actualizarGenero = generoServicio.actualizarGenero(id,generoDTO);

        if (actualizarGenero!=null){
            return  ResponseEntity.status(HttpStatus.CREATED).body(actualizarGenero);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("todoslosgeneros")
    public ResponseEntity<List<GeneroDTO>> mostrarTodosLosGeneros(){
        List<GeneroDTO> todosLosGeneros =  generoServicio.mostrarTodosLosGeneros();
        return ResponseEntity.ok(todosLosGeneros);
    }

    @GetMapping("mostrargenero/{id}")
    public ResponseEntity<Optional<GeneroDTO>> buscarPorId(@PathVariable("id") Integer id){
        Optional<GeneroDTO> generoDTOPorId = generoServicio.buscarPorId(id);

        if (generoDTOPorId == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(generoDTOPorId);
    }

    @DeleteMapping("eliminargenero/{id}")
    public ResponseEntity<Void> eliminarGenero(@PathVariable("id") Integer id){
        try {
            generoServicio.eliminarGeneroPorId(id);
            return ResponseEntity.noContent().build();
        }catch ( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
