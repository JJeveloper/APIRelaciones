package com.web.apirelaciones.model.dto;

public class CancionesRelacionDTO {

    private int idcancion;

    private String titulo;

    private String duracion;

    private CantantesDTO cantantes;

    private GeneroDTO genero;

    public CancionesRelacionDTO() {
    }

    public CancionesRelacionDTO(String titulo, String duracion, CantantesDTO cantantes, GeneroDTO genero) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.cantantes = cantantes;
        this.genero = genero;
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

    public CantantesDTO getCantantes() {
        return cantantes;
    }

    public void setCantantes(CantantesDTO cantantes) {
        this.cantantes = cantantes;
    }

    public GeneroDTO getGenero() {
        return genero;
    }

    public void setGenero(GeneroDTO genero) {
        this.genero = genero;
    }
}
