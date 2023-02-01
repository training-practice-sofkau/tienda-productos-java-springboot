package com.sofkau.qa.tiendaproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.HashMap; // import the HashMap class

@Service
public class TiendaDeJuegos {
    Scanner sc = new Scanner(System.in);
//    public List<String> proucts = Arrays.asList("1. God Of War","2. Grand Theft Auto V","3. Spiderman","4. Red Dead Redemption","5. Rocket League","6. Fifa 23","7. Elden Ring",
//            "8. Minecraft","9. Fortnite","10. Assassins Creed");
    @Autowired
    FacturaService facturaService;
    private List<Producto> products;
    private List<CarritoCompras> carrito;
    //Declarando el inventario de Videojuegos

//    public List<Producto> carrito;


    public TiendaDeJuegos() {
        products = new ArrayList<>();
        carrito = new ArrayList<>();
        products.add(new Producto(1, "God of War",150000,20));
        products.add(new Producto(2, "Grand Theft Auto V",120000,15));
        products.add(new Producto(3, "Spiderman",210000,12));
        products.add(new Producto(4, "Red dead Redemption",160000,8));
        products.add(new Producto(5, "Rocket League",50000,17));
        products.add(new Producto(6, "Fifa 23",220000,40));
        products.add(new Producto(7, "Elden Ring",180000,24));
        products.add(new Producto(8, "Minecraft",90000,13));
        products.add(new Producto(9, "Call of Duty",120000,19));
        products.add(new Producto(10, "Assassins Creed",80000,16));
    }

//    public List<Producto> mostrarProductos() {
//        System.out.println("Videojuegos Disponibles");
//        return products.stream().filter(p -> p.getId() < 11).collect(Collectors.toList());
//    }

    public void mostrarProductos() {
        System.out.println("Videojuegos Disponibles");
        for(Producto producto: products){
            System.out.println(producto.getId()+" "+producto.getNombre());
        }
        System.out.println("11. Finalizar Compra");
    }
    public void addToCart() {
        double total = 0;
        boolean comprar = true;
        while(comprar){
            System.out.println("Escoja el numero correspondiente al juego que desea añadir y despues de dar Enter ingrese la cantidad de copias deseada de este mismo\n");
            int index = sc.nextInt();
            int cant = sc.nextInt();
            if(index == 11) {
                System.out.println("Ingresa su nombre para generar la factura");
                String nombre = sc.next();
                Factura factura= new Factura(nombre, carrito, total);
                facturaService.generarFactura(factura);
                System.out.println("Factura Almacenada");
                comprar = false;
            }
            else if(index < 11){
                for (Producto producto: products){
                    if (producto.getId() == index){
                        carrito.add(new CarritoCompras(producto.getNombre(), cant));
                        System.out.println("Producto anadido al carrito");
                        updateInventario(producto.getNombre(), cant);
                        total = total + (producto.getPrecio() *cant);
                    }
                }
            }
        }
        System.out.println(carrito);
    }

    public void updateInventario(String name, int cant) {
        System.out.println("***Actualizando el Stock***");
        for (Producto producto: products){
            if (producto.getNombre() == name){
                producto.setStock(producto.getStock()-cant);
            }
        }
    }
}
