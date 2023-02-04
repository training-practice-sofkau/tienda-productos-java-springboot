package com.sofkau.qa.tiendaproductos.services;

import com.sofkau.qa.tiendaproductos.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public
class ProductoService {
    //creo mi lista de productos
    public static List<Producto> productos;

    //agrego productos a esta lista creada

    public ProductoService() {
        productos = new ArrayList<>();
        productos.add(new Producto(1, "Zapatos", 160.000, 5));
        productos.add(new Producto(2, "Camisetas", 28.000, 20));
        productos.add(new Producto(3, "Pantalones", 90.000, 12));
        productos.add(new Producto(4, "Camisa", 50.000, 15));
        productos.add(new Producto(5, "Jogger ", 33.600, 42));
        productos.add(new Producto(6, "Pantalonetas ", 30.000, 10));
        productos.add(new Producto(7, "Boxers ", 10.000, 22));
        productos.add(new Producto(8, "Medias", 8.000, 100));
        productos.add(new Producto(9, "Chaquetas", 150.000, 22));
        productos.add(new Producto(10, "Busos", 75.000, 40));
    }

    //creo un get para la lista de productos
    // con el objetivo de mostrar , de obtener despues esta lista
    public static List<Producto> getProductosDisponibles() {

        return productos.stream().filter(p -> p.getQuantity() > 0).collect(Collectors.toList());
    }

    //creo metodo imprimir productos disponibes
    public void imprimirProductosDispo() {
        System.out.println("Productos disponibles:");


        for (Producto producto : getProductosDisponibles()) {
            System.out.println(producto.toString());//imprimo mi lista
        }
    }



    //creo lista para los productos que he vendido ya en el menu de arriba
    public static List<Producto> productosVendidos(int id, int quantity) {


        Producto product = productos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);



        if (product == null || product.getQuantity() < quantity) {
            return new ArrayList<>();
        }
        //uso el metodo set de prductoService para validar el stock que hay disponible en tienda
        product.setQuantity(product.getQuantity() - quantity);

        //creo lista de productos vendidos
        List<Producto> productosVendidos = new ArrayList<>();
        //recorro la lista para agregar los productos vendidos
        for (int i = 0; i < quantity; i++) {
            productosVendidos.add(product);
        }
        return productosVendidos;
    }
}
