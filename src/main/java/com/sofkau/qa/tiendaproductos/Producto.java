package com.sofkau.qa.tiendaproductos;


import java.util.List;

public class Producto {

    private String cliente;
    private List<Teclado> teclados;
    private List<Diadema> diademas;

    public Producto() {

    }
    public void agregarDiadema(Diadema diadema){
        diademas.add(diadema);
    }

}
