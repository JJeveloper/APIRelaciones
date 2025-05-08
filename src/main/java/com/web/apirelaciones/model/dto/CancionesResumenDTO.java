package com.web.apirelaciones.model.dto;

import java.util.List;

public class CancionesResumenDTO {

    private int idcancion;

    private String titulo;

    private String duracion;

    public CancionesResumenDTO() {
    }

    public CancionesResumenDTO(String titulo, String duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public int getIdcancion() {
        return idcancion;
    }

    public void setIdcancion(int idcancion) {
        this.idcancion = idcancion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

}
