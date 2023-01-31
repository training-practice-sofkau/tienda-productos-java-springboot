package com.sofkau.qa.tiendaproductos;
public class Producto {
    private String nombre,descripcion;
    private int cantidad;
    private long precio;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public long getPrecio() {
        return precio;
    }
    public void setPrecio(long precio) {
        this.precio = precio;
    }
}
class ProductoBuilder{
    private Producto producto;
    public ProductoBuilder(){
        producto=new Producto();
    }
    public ProductoBuilder nombre(String nombre){
        producto.setNombre(nombre);
        return this;
    }
    public ProductoBuilder cantidad(int cantidad){
        producto.setCantidad(cantidad);
        return this;
    }
    public ProductoBuilder precio(long precio){
        producto.setPrecio(precio);
        return this;
    }
    public ProductoBuilder descripcion(String descripcion){
        producto.setDescripcion(descripcion);
        return this;
    }
    public Producto build(){
        return producto;
    }
}
