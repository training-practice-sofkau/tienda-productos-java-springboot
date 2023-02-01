package com.sofkau.qa.tiendaproductos;


import org.springframework.stereotype.Service;


public class Persona {

    private String nombre;
    private String apéllido;
    private String documento;
    private String correo;


    public Persona() {
    }

    public Persona(String nombre, String apéllido, String documento, String correo) {
        this.nombre = nombre;
        this.apéllido = apéllido;
        this.documento = documento;
        this.correo = correo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApéllido() {
        return apéllido;
    }

    public void setApéllido(String apéllido) {
        this.apéllido = apéllido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apéllido='" + apéllido + '\'' +
                ", documento='" + documento + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
