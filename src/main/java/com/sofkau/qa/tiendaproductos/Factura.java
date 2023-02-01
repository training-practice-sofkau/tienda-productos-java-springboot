package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;

public class Factura {
    String nombreCliente;
    double total = 0;
    ArrayList<FacturaDetalle> detallesFactura;

    public Factura(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.detallesFactura = new ArrayList<>();
    }

    public void agregarDetalle(Producto producto, int cantidad) {
        FacturaDetalle detalle = new FacturaDetalle(producto, cantidad);
        this.detallesFactura.add(detalle);
        this.total += detalle.getTotal();
    }

    public ArrayList<FacturaDetalle> getDetallesFactura (){
        return this.detallesFactura;
    }

    public void generarFactura() {
        System.out.println("Factura generada \n" +
                "------------------------- \n" +
                "Cliente: " + this.nombreCliente + "\n" +
                "-------------------------- \n" +
                "Total: $" + this.total + "\n" +
                "-------------------------- \n" +
                this.imprimirDetalle()
        );
    }

    public String imprimirDetalle() {
        String salida = "";
        salida += "| Producto \t| Cantidad \t | Total \n";
        for (FacturaDetalle detalle : this.detallesFactura) {
            String producto = detalle.getProducto().getNombreProducto();
            int cantidad = detalle.getCantidad();
            double total = detalle.getTotal();
            salida += "| " + producto + " \t | " + cantidad + " \t | " + total + "\n";
        }
        return salida;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getTotal(){
        return this.total;
    }
}
