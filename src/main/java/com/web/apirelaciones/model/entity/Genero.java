package com.web.apirelaciones.model.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgenero")
    private int idgenero;

    private String nombre;

    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    List<Canciones> canciones = new ArrayList<>();

    public Genero() {
    }

    public Genero(String nombre, List<Canciones> canciones) {
        this.nombre = nombre;
        this.canciones = canciones;
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

    public List<Canciones> getCanciones() {
        return canciones;
    }

    public void agregarCanciones(Canciones cancion){
        this.canciones.add(cancion);
        cancion.setGenero(this);
    }

    public void eliminarCanciones(Canciones cancion){
        this.canciones.remove(cancion);
        cancion.setCantantes(null);
    }

}
