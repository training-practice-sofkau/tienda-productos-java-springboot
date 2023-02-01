package com.sofkau.qa.tiendaproductos;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Factura {
    private Cliente cliente;
    private LocalDateTime fecha;
    private Producto producto;
    public static void crearFactura(Cliente cliente,Producto producto){
        Factura factura=new Factura(cliente,LocalDateTime.now(),producto);
        BaseDeDatos.getBaseDeDatos().addFacturas(factura);
        System.out.println(factura);
    }
    public Factura(Cliente cliente, LocalDateTime fecha, Producto producto) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.producto = producto;
    }
    @Override
    public String toString() {
        DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Al cliente: "+cliente.getNombre()+
                "\nIdentificado: "+cliente.getId()+
                "\nen la fecha: "+fecha.format(formato)+
                "\nCompró el producto: "+producto.getNombre()+
                "\n"+producto.getDescripcion()+
                "\nCantidad comprada: "+producto.getCantidad();
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
