package com.sofkau.qa.tiendaproductos;

public class Producto {

    private String nombreProducto;
    private Integer costo;

    private Integer cantidad;


    public Producto(String nombreProducto, Integer costo, Integer cantidad) {
        this.nombreProducto = nombreProducto;
        this.costo = costo;
        this.cantidad = cantidad;
    }


    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombreProducto='" + nombreProducto + '\'' +
                ", costo=" + costo +
                ", cantidad=" + cantidad +
                '}';
    }
}
