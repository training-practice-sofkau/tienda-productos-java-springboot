package com.sofkau.qa.tiendaproductos;

public class ProductoOrdernado {
    public double getPrecio;
    private Producto producto;
    // La cantidad de productos pedidos
    private int cantidad;

    // Constructor para crear un pedido con un producto y cantidad especificados
    public ProductoOrdernado(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Getter para obtener el producto pedido
    public Producto getProducto() {
        return producto;
    }

    // Getter para obtener la cantidad de productos pedidos
    public int getCantidad() {
        return cantidad;
    }

    // Sobreescritura del método toString para devolver una representación en forma de cadena de texto del pedido
    @Override
    public String toString() {
        return producto.getNombre() + " x " + cantidad + " ($" + producto.getPrecio() * cantidad + ")";
    }
}
