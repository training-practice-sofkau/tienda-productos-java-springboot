package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Component
public class ProductoGuardado {
    private static List<Producto> productos = Arrays.asList(
            new Producto("iPhone 12 Pro", 1200000),
            new Producto("MacBook Pro", 1100000),
            new Producto("Samsung Galaxy S21 Ultra", 2150000),
            new Producto("PortÁtil ASUS ROG", 2000000),
            new Producto("Sony PlayStation 5", 2500000),
            new Producto("XBOX ONE", 1000000),
            new Producto("Diademas SoundCore", 400000),
            new Producto("Teclado Logitech", 200000),
            new Producto("Mouse Redragon", 100000),
            new Producto("Monitor LG", 700000)
    );

    public static List<Producto> getAllProductos() {
        return productos;
    }
}
