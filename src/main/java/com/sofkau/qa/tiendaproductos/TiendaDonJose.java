package com.sofkau.qa.tiendaproductos;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


public class TiendaDonJose {
    private String  nombre;
    private List<Producto> productos;
    private List<Cliente> registro;

    private int precioProducto;

    private int totalFactura;

    private String facturaCliente;
public TiendaDonJose(String nombre) {
        this.nombre = nombre;
        productos = new ArrayList<>(List.of(new Producto("1","sal",100,3000),
                new Producto("2","azucar",100,2500),
                new Producto("3","cereal",100,5000),
                new Producto("4","aceite",100,7000),
                new Producto("5","cerveza",100,2800),
                new Producto("6","ron",100,60000),
                new Producto("7","aguariente",100,50000),
                new Producto("8","doritos",100,4000),
                new Producto("9","mantequilla",100,3000),
                new Producto("10","salsa de tomate",100,4500)));
        registro = Arrays.asList(new Cliente("Andres",44444444),new Cliente("Juan",666666666));
        }


    public void verRegistro(){
            System.out.println(registro.toString());
        }

        public void verProductos(){
            System.out.println(productos.toString());
        }
        public void iterarProducto(String nombre){
           List<Producto> productosFiltradosNombre  = productos.stream().filter(producto -> nombre.equals(producto.getNombre())).collect(Collectors.toList());
            List<Integer> precioFiltrado = productosFiltradosNombre.stream().map(producto -> producto.getPrecio()).collect(Collectors.toList());
            System.out.println(precioFiltrado);
            this.precioProducto = precioFiltrado.get(0);
        }

    @Override
    public String toString() {
        return "TiendaDonJose{" +
                "registro=" + registro +
                '}';
    }

    public int getPrecioProducto() {
        return precioProducto;
    }



    public void factura(Cliente cliente) {
        this.facturaCliente = " Nombre: "+ cliente.getNombre() +
        " Cedula: " + cliente.getCc() + " Productos : " + cliente.carritoDeCompra.toString() + " Total factura : " + totalFactura;
        System.out.println(facturaCliente);
    }

    public void totalFactura(Cliente cliente){
        List<Integer> totalxcantidad  = cliente.carritoDeCompra.stream().map(producto -> producto.getPrecio() * producto.getCantidadProducto()).collect(Collectors.toList());
        this.totalFactura = totalxcantidad.stream().reduce(0,(a,b) -> a + b );
    }

    public void agregarProducto(Producto producto) {
      productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Cliente> getRegistro() {
        return registro;
    }

    public void setRegistro(List<Cliente> registro) {
        this.registro = registro;
    }
}

