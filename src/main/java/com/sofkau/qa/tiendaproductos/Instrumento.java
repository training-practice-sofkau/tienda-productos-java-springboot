package com.sofkau.qa.tiendaproductos;

public class Instrumento {
    private String nombre;
    private String clase;
    private int valor;
    private String cantidad;
    private String estado;

    public Instrumento (String nombre, String clase, int valor, String estado){
        this.nombre=nombre;
        this.clase=clase;
        this.valor=valor;
        this.estado=estado;
    }
    public String darNombre(){
        return nombre;
    }
    public String darClase(){
        return clase;
    }
    public int darValor(){
        return valor;
    }
    public String darEstado(){
        return estado;
    }
}
