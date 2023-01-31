package com.sofkau.qa.tiendaproductos.datos;

import com.sofkau.qa.tiendaproductos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductosStock {
    @Autowired
    public StockMethods stockMethods;
    Producto guantes = new Producto("Guantes", 20000);
    Producto pantaloneta = new Producto("Pantaloneta", 10000);
    Producto guayos = new Producto("Guayos", 50000);
    Producto medias = new Producto("Medias", 5000);
    Producto espinillera = new Producto("Espinillera", 6000);
    Producto camiseta = new Producto("Camiseta", 15000);
    Producto camisilla = new Producto("camisilla", 5000);
    Producto balon = new Producto("Balón", 30000);
    Producto gorra = new Producto("Gorra", 8000);
    Producto vendaje = new Producto("Vendaje", 3000);

    public void getStock(){
        // Se agregan productos a la lista de Stock
        stockMethods.agregar(vendaje);
        stockMethods.agregar(gorra);
        stockMethods.agregar(balon);
        stockMethods.agregar(camisilla);
        stockMethods.agregar(camiseta);
        stockMethods.agregar(espinillera);
        stockMethods.agregar(medias);
        stockMethods.agregar(guayos);
        stockMethods.agregar(pantaloneta);
        stockMethods.agregar(guantes);

        // Se imprime la lista de productos en Stock
        stockMethods.listar();

    }

}
