package com.sofkau.qa.tiendaproductos;

import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class Cafeteria {
    public List<Producto> productoList;
    public List<Producto> productoEnStock;
    private ArrayList<Factura> facturas;
    private Factura facturaEnCurso;

    /**
     * Constructor
     */
    public Cafeteria() {
        this.productoList = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }

    /**
     * Método que permite mostrar los productos que están disponibles
     */
    public void mostrarProductos() {
        System.out.println("\n---Lista de productos disponibles---\n");

        this.productoEnStock = new ArrayList<>();

        for (Producto prod : productoList) {
            if (prod.getStock() > 0) {
                productoEnStock.add(prod);
            }
        }

        int indice = 1;

        for (Producto prod : productoEnStock) {
            System.out.println(indice + ") Producto: " + prod.getNombreProducto() + "\n"
                    + "Precio: $" + prod.getValor() + "\n"
                    + "Cantidad: " + prod.getStock()
                    + "\n"
            );
            indice++;
        }
    }

    /**
     * Método que permite agregar un nuevo producto
     *
     * @param producto
     */
    public void agregarProductos(Producto producto) {
        System.out.println("Producto añadido: " + producto.getNombreProducto());
        productoList.add(producto);
    }

    public void iniciarCompra() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Nombre del cliente: ");
        String nombreCliente = entrada.nextLine();

        this.facturaEnCurso = new Factura(nombreCliente);

        this.mostrarProductos();

        boolean comprando = true;
        while (comprando) {
            System.out.println("¿Qué producto deseas? (Ingresa el índice): ");
            int indice = entrada.nextInt();
            Producto producto = this.productoEnStock.get(indice - 1);

            if (producto != null) {
                System.out.println("¿Cuántos quieres? (Máximo: " + producto.getStock() + ")");
                int cantidad = entrada.nextInt();

                if (cantidad <= producto.getStock()){
                    this.facturaEnCurso.agregarDetalle(producto, cantidad);
                    System.out.println("Producto añadido a compra, total: " + this.facturaEnCurso.getTotal());
                    System.out.println("¿Deseas seguir comprando? (s/n)");
                    char respuesta = entrada.nextLine().charAt(0);
                    comprando = respuesta == 's';
                } else {
                    System.out.println("No contamos con esa cantidad para ese producto");
                }
            } else {
                System.out.println("El producto seleccionado no existe");
            }
        }
    }

    public void generarFactura(){
        this.facturaEnCurso.generarFactura();
        this.facturas.add(facturaEnCurso);
        ArrayList<FacturaDetalle> detalles = this.facturaEnCurso.getDetallesFactura();
        for (FacturaDetalle detalle : detalles){
            Producto productoDetalle = detalle.getProducto();
            for(Producto producto : this.productoList){
                if(productoDetalle.getNombreProducto().equalsIgnoreCase(producto.getNombreProducto())){
                    producto.setStock(producto.getStock() - detalle.getCantidad());
                }
            }
        }
        this.facturaEnCurso = null;
    }

    public void imprimirHistorialVentas (){
        int contador = 1;
        for (Factura factura : this.facturas){
            System.out.println("#" + contador + "- " + factura.getNombreCliente() + "Total: " + factura.getTotal());
        }
    }

    @Override
    public String toString() {
        return "\n---Lista de productos---\n" + productoList;
    }
}
