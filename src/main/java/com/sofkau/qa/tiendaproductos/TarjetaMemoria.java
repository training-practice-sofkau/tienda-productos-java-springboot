package com.sofkau.qa.tiendaproductos;

public class TarjetaMemoria {
    private  String capacidad;

    public TarjetaMemoria(String capacidad) {
        this.capacidad = capacidad;
    }

    public String capacidad() {
        return capacidad;
    }

    public TarjetaMemoria setCapacidad(String capacidad) {
        this.capacidad = capacidad;
        return this;
    }

    @Override
    public String toString() {
        return
                "Capacidad de la targeta de memoria: " + capacidad +
                '}';
    }
}
