package com.sofkau.qa.tiendaproductos;

public class Comprador {

    private String nombre;
    private int cedula;

    public Comprador (String nombre, int cedula){
        this.nombre=nombre;
        this.cedula=cedula;
    }
    public String darNombre(){
        return nombre;
    }
    public int darCedula(){
        return cedula;
    }
}
