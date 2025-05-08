package com.web.apirelaciones.controller;

import com.web.apirelaciones.model.dto.CantantesCancionesDTO;
import com.web.apirelaciones.model.dto.CantantesDTO;
import com.web.apirelaciones.model.dto.GeneroDTO;
import com.web.apirelaciones.model.entity.Cantantes;
import com.web.apirelaciones.service.interfaces.CantantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cantantes/")
public class CantantesController {

    private CantantesService cantantesService;

    @Autowired
    public CantantesController(CantantesService cantantesService) {
        this.cantantesService = cantantesService;
    }

    @PostMapping("crearcantante")
    public ResponseEntity<CantantesDTO> crearCantante(@RequestBody CantantesDTO cantanteDTO) {
        CantantesDTO crearCantante = cantantesService.crearCantante(cantanteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(crearCantante);
    }

    @PutMapping("actualizarcantante/{id}")
    public ResponseEntity<CantantesDTO> actualizarCantante(@PathVariable("id") Integer id, @RequestBody CantantesDTO cantante) {

        if (cantante.getNombre()==null){
            return ResponseEntity.notFound().build();
        }

        CantantesDTO actulizarCantantesDTO = cantantesService.actualizarCantante(id, cantante);

        if (actulizarCantantesDTO!= null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(actulizarCantantesDTO);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("mostrartodosloscantantes")
    public ResponseEntity<List<CantantesDTO>> mostrarTodosLosCantantes() {
        List<CantantesDTO> todosLosCantantes = cantantesService.mostrarTodosLosCantantes();
        return ResponseEntity.ok(todosLosCantantes);
    }

    @GetMapping("mostartcantanteporid/{id}")
    public ResponseEntity<Optional<CantantesCancionesDTO>> mostrarCantante(@PathVariable("id") Integer id) {

        Optional<CantantesCancionesDTO> cantanteDTOPorId = cantantesService.buscarCantantePorId(id);

        if (cantanteDTOPorId == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cantanteDTOPorId);
    }

    @DeleteMapping("eliminarcantante/{id}")
    public ResponseEntity<Void> eliminarcantante(@PathVariable("id") Integer id) {
        try {

            cantantesService.eliminarCantantePorId(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

}
