package com.web.apirelaciones.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "canciones")
public class Canciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcancion;

    private String titulo;

    private String duracion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cantantes_idcantante")
    private Cantantes cantantes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genero_idgenero")
    private Genero genero;

    public Canciones() {
    }

    public Canciones(String titulo, String duracion, Cantantes cantantes, Genero genero) {
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

    public Cantantes getCantantes() {
        return cantantes;
    }

    public void setCantantes(Cantantes cantantes) {
        this.cantantes = cantantes;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
