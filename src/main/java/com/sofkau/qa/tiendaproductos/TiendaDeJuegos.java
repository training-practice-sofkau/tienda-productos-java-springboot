package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class TiendaDeJuegos {
    Scanner sc = new Scanner(System.in);
    public List<String> products = Arrays.asList("1. God Of War","2. Grand Theft Auto V","3. Spiderman","4. Red Dead Redemption","5. Rocket League","6. Fifa 23","7. Elden Ring",
            "8. Minecraft","9. Fortnite","10. Assassins Creed");

    public List<Producto> carrito;
    public TiendaDeJuegos() {
        this.carrito = new ArrayList<>();
    }

    public void mostrarProductos() {
        products.forEach(juego -> {
            System.out.println(juego);
        });
    }
    public void addToCart() {
        boolean comprar = true;
        while(comprar){
            System.out.println("Escoja el numero correspondiente al juego que desea añadir y despues de dar Enter ingrese la cantidad de copias deseada de este mismo\n");
            int index = sc.nextInt();
            int cant = sc.nextInt();
            if(index > 10) {
                comprar = false;
            }
            else{
                String name = products.get(index-1);
                Producto product = new Producto(name, cant);
                carrito.add(product);
                System.out.println("Producto Añadido al Carrito");
            }
        }
        System.out.println(carrito);
    }
}
