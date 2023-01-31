package com.sofkau.qa.tiendaproductos;

public class ProdCantidad extends Producto{
    private int cantidad;

    public ProdCantidad(String id, String nombre, double precio, int cantidad) {
        super(id, nombre, precio);
        this.cantidad= cantidad;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void disminuirCantidad(int cantidad) {
        this.cantidad = this.cantidad - cantidad;
    }

    @Override
    public String toString() {
        return super.toString() + " cantidad = " + this.cantidad;
    }
}
