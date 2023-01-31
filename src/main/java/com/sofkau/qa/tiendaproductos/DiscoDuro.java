package com.sofkau.qa.tiendaproductos;

public class DiscoDuro {
    private String capacidad;

    public DiscoDuro(String capacidad) {
        this.capacidad = capacidad;
    }

    public String capacidad() {
        return capacidad;
    }

    public DiscoDuro setCapacidad(String capacidad) {
        this.capacidad = capacidad;
        return this;
    }

    @Override
    public String toString() {
        return
                "Capacidad del disco duro: " + capacidad  +
                '}';
    }
}
