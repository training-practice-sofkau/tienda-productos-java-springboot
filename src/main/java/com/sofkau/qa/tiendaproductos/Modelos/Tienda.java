package com.sofkau.qa.tiendaproductos.Modelos;

import com.sofkau.qa.tiendaproductos.Modelos.Factura;
import com.sofkau.qa.tiendaproductos.Modelos.ProdCantidad;
import com.sofkau.qa.tiendaproductos.Modelos.Stock;

import java.util.ArrayList;
import java.util.List;


public class Tienda {
    private Stock misProductos;
    private List<Factura> misFacturas;
    private Factura factuaActual;
    private ProdCantidad productoEntrada;

    public Tienda(Stock misProductos) {
        this.misProductos = misProductos;
        this.misFacturas = new ArrayList<>();
    }

    public void listarProductos() {
        misProductos.listarProductos();
    }

    public void agregarFactura(Factura miFactura) {
        factuaActual = miFactura;
        misFacturas.add(factuaActual);
    }

    public void agregarProductos(ProdCantidad productoEntrada) {
        this.productoEntrada = productoEntrada;
        if(evaluarStock()) {
            factuaActual.agregarProductosFactura(productoEntrada);
            actualizarSock();
        }else {
            System.out.println("No hay suficiente stock en el inventario");
        }
    }

    private boolean evaluarStock() {
        ProdCantidad temporal = misProductos.obtenerProducto(this.productoEntrada.getId());
        if (this.productoEntrada.getCantidad() <= temporal.getCantidad()) {
            return true;
        } else {
            return false;
        }
    }

    private void actualizarSock() {
        ProdCantidad temporal = misProductos.obtenerProducto(this.productoEntrada.getId());
        misProductos.disminuirStockProducto(temporal.getId(), this.productoEntrada.getCantidad());
    }

    public List<Factura> obtenerFacturas(){
        return misFacturas;
    }

    public void generarTotal(){
        for (Factura factura : misFacturas) {
            factura.totalFactura();
        }
    }

    public void obtenerFacturasCliente(String cedula) {
        for (Factura factura : misFacturas) {
            if(factura.getCliente().getCedula().equals(cedula)) {
                System.out.println(factura);
            }
        }
    }
}
