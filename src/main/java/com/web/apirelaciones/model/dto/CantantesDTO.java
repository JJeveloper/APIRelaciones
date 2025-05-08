package com.web.apirelaciones.model.dto;

public class CantantesDTO {

    private int idcantante;

    private String nombre;

    public CantantesDTO() {
    }

    public CantantesDTO(String nombre) {
        this.nombre = nombre;
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
}
