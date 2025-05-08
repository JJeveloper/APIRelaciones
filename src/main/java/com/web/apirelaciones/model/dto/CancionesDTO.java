package com.web.apirelaciones.model.dto;

public class CancionesDTO {

    private int idcancion;

    private String titulo;

    private String duracion;

    private int idcantante;

    private int idgenero;


    public CancionesDTO() {
    }

    public CancionesDTO(String titulo, String duracion, int idcantante, int idgenero) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.idcantante = idcantante;
        this.idgenero = idgenero;
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

    public int getIdcantante() {
        return idcantante;
    }

    public void setIdcantante(int idcantante) {
        this.idcantante = idcantante;
    }

    public int getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(int idgenero) {
        this.idgenero = idgenero;
    }
}
