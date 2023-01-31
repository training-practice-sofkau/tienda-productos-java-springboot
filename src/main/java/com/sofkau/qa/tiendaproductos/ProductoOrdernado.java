package com.sofkau.qa.tiendaproductos;

public class ProductoOrdernado {
    private Producto producto;
    private int cantidad;

    // Constructor para crear un pedido con un producto y cantidad especificados
    public ProductoOrdernado(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    public Producto getProducto() {
        return producto;
    }
    public int getCantidad() {
        return cantidad;
    }

    // Sobreescritura del método toString para devolver una representación en forma de cadena de texto del pedido
    @Override
    public String toString() {
        return producto.getNombre() + " x " + cantidad + " ($" + producto.getPrecio() * cantidad + ")";
    }
}
