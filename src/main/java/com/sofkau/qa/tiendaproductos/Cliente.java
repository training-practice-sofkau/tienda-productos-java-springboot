package com.sofkau.qa.tiendaproductos;

import java.util.LinkedList;

public class Cliente {

    private String nombre;
    private int id;
    private LinkedList<ProductoCompra> productos;
    private LinkedList<Factura> facturas;

    public Cliente(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.productos=new LinkedList<>();
        this.facturas=new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void verFacturas(){
        if(!facturas.isEmpty()){
            for(Factura factura:facturas){
                factura.generarFactura();
            }
        }
    }

    public boolean verificarFacturas(){
        return facturas.isEmpty();
    }

    public void verProductos(){
        if(!productos.isEmpty()){
            for(ProductoCompra productoCompra:productos){
                System.out.println(productoCompra.toString());
            }
        }
    }

    public void aniadirProductoCompra(ProductoCompra productoCompra){
        productos.add(productoCompra);
    }

    public void aniadirFactura(Factura factura){
        facturas.add(factura);
    }

    public boolean verificarCarrito(){
        return productos.isEmpty();
    }

    public void verificarProductoCarrito(int id, int cantidad){
        if(!productos.isEmpty()){
            for(ProductoCompra productoCompra:productos){
                if(productoCompra.getId()==id){
                    productoCompra.setCantidad(productoCompra.getCantidad()+cantidad);
                }
            }
        }
    }

    public boolean verificarProducto(int id){
        if(!productos.isEmpty()){
            for(ProductoCompra productoCompra:productos){
                if(productoCompra.getId()==id){
                    return true;
                }
                break;
            }
        }
        return false;
    }

    public LinkedList<ProductoCompra> getProductos() {
        return productos;
    }

    public void clearCarrito(){
        productos.clear();
    }
}
