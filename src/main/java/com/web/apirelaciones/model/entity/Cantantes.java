package com.web.apirelaciones.model.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cantantes")
public class Cantantes {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int idcantante;

    private String nombre;

    @OneToMany(mappedBy = "cantantes", cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    private List<Canciones> canciones = new ArrayList<>();

    public Cantantes() {
    }

    public Cantantes(int idcantante, String nombre) {
        this.idcantante = idcantante;
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

    public List<Canciones> getCanciones() {
        return canciones;
    }

    public void agregarCanciones(Canciones cancion){
        this.canciones.add(cancion);
        cancion.setCantantes(this);
    }

    public void eliminarCanciones(Canciones cancion){
        this.canciones.remove(cancion);
        cancion.setCantantes(null);
    }

}
