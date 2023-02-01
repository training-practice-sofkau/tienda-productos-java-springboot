package com.sofkau.qa.tiendaproductos;

public class CarritoCompras {
    private String name;
    private int cant;

    public CarritoCompras(String name, int cant) {
        this.name = name;
        this.cant = cant;
    }

    public String getName() {
        return name;
    }

    public int getCant() {
        return cant;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    @Override
    public String toString() {
        return "CarritoCompras{" +
                "name='" + name + '\'' +
                ", cant=" + cant +
                '}';
    }
}
