package com.web.apirelaciones.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "canciones")
public class Canciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcancion;

    private String titulo;

    private Date fechaestreno;

    private String duracion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcantante")
    private Cantantes cantantes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idgenero")
    private Genero genero;

    public Canciones() {
    }

    public Canciones(String titulo, Date fechaestreno, String duracion) {
        this.titulo = titulo;
        this.fechaestreno = fechaestreno;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaestreno() {
        return fechaestreno;
    }

    public void setFechaestreno(Date fechaestreno) {
        this.fechaestreno = fechaestreno;
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
