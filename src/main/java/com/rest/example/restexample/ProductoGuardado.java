package com.rest.example.restexample;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
@RequestMapping("/productos")
public class ProductoGuardado {
    static List<Producto> productos = Arrays.asList(
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
