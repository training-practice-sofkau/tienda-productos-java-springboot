package com.sofkau.qa.tiendaproductos;

public class Teclado {
    private final int idTeclado;
    private  static int contadorTeclado;
    private String tipoTeclado;

    public Teclado(String tipoTeclado) {
        this.idTeclado = ++Teclado.contadorTeclado;
        this.tipoTeclado = tipoTeclado;
    }

    @Override
    public String toString() {
        return   " Id Teclado :" + idTeclado + ",Teclado de tipo: "+this.tipoTeclado +
                '}';
    }
}
