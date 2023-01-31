package com.sofkau.qa.tiendaproductos;

public class FacturaDetalle {
    private Producto producto;
    private int cantidad = 0;
    private  double total;

    public FacturaDetalle(Producto producto, int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = producto.getValor() * cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
