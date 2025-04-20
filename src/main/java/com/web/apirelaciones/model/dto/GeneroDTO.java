package com.web.apirelaciones.model.dto;

public class GeneroDTO {

    private int idgenero;

    private String nombre;

    public GeneroDTO() {
    }

    public GeneroDTO(int idgenero, String nombre) {
        this.idgenero = idgenero;
        this.nombre = nombre;
    }

    public GeneroDTO(String nombre) {
        this.nombre = nombre;
    }

    public int getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(int idgenero) {
        this.idgenero = idgenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
