package com.sofkau.qa.tiendaproductos;

public class Instrumento {
    private String nombre;
    private String familia;
    private int valor;
    private String cantidad;
    private String estado;
    private int referencia;

    public Instrumento (String nombre, String familia, int valor, String estado, int referencia){
        this.nombre=nombre;
        this.familia=familia;
        this.valor=valor;
        this.estado=estado;
        this.referencia=referencia;
    }
    public String darNombre(){
        return nombre;
    }
    public String darFamilia(){
        return familia;
    }
    public int darValor(){
        return valor;
    }
    public String darEstado(){
        return estado;
    }
    public int darReferencia(){
        return referencia;
    }
}
