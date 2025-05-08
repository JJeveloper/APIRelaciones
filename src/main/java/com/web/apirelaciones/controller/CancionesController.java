package com.web.apirelaciones.controller;

import com.web.apirelaciones.model.dto.CancionesDTO;
import com.web.apirelaciones.model.dto.CancionesRelacionDTO;
import com.web.apirelaciones.model.dto.CantantesDTO;
import com.web.apirelaciones.model.entity.Canciones;
import com.web.apirelaciones.service.interfaces.CancionesService;
import com.web.apirelaciones.service.interfaces.CantantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/canciones/")
public class CancionesController {

    private CancionesService cancionesService;

    @Autowired
    public CancionesController(CancionesService cancionesService) {
        this.cancionesService = cancionesService;
    }

    @PostMapping("crearcancion")
    public ResponseEntity<CancionesDTO> crearCanciones(@RequestBody CancionesDTO cancionesDTO) {

        CancionesDTO nuevaCancion = cancionesService.crearCanciones(cancionesDTO);
        System.out.println("cancion " + nuevaCancion);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCancion);
    }

    @PutMapping("actualizarcancion/{id}")
    public ResponseEntity<CancionesDTO> actualizarCancion(@PathVariable("id") Integer id, @RequestBody CancionesDTO cancionesDTO){

        if (cancionesDTO.getDuracion()==null || cancionesDTO.getTitulo()==null || (cancionesDTO.getIdcantante() + "") == "" || (cancionesDTO.getIdgenero() + "") == "" ){
            return ResponseEntity.notFound().build();

        }

        CancionesDTO actualizarCancionesDTO = cancionesService.actualizarCantante(id,cancionesDTO);

        if (actualizarCancionesDTO!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(actualizarCancionesDTO);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("todaslascanciones")
    public ResponseEntity<List<CancionesDTO>> todaslascanciones() {
        return ResponseEntity.ok(cancionesService.mostrarTodasLasCanciones());
    }

    @GetMapping("mostrarcancionporid/{id}")
    public ResponseEntity<Optional<CancionesRelacionDTO>> mostrarCancionPorId(@PathVariable("id") Integer id) {

        Optional<CancionesRelacionDTO> cancionesDTOPorId = cancionesService.buscarCancionPorId(id);

        if (cancionesDTOPorId==null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cancionesDTOPorId);
    }

    @DeleteMapping("eliminarcancion/{id}")
    public ResponseEntity<Void> eliminarCantante(@PathVariable("id") Integer id){
        try {

            cancionesService.eliminarCancionPorId(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
}
