package com.web.apirelaciones.model.dto;

import java.util.ArrayList;
import java.util.List;

public class CantantesCancionesDTO {

    private int idcantante;

    private String nombre;

    private List<CancionesResumenDTO> canciones;

    public CantantesCancionesDTO() {
    }

    public CantantesCancionesDTO(String nombre, List<CancionesResumenDTO> canciones) {
        this.nombre = nombre;
        this.canciones = canciones;
    }

    public int getIdcantante() {
        return idcantante;
    }

    public void setIdcantante(int idcantante) {
        this.idcantante = idcantante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<CancionesResumenDTO> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<CancionesResumenDTO> canciones) {
        this.canciones = canciones;
    }
}
