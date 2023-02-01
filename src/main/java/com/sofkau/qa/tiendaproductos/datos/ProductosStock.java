package com.sofkau.qa.tiendaproductos.datos;

import com.sofkau.qa.tiendaproductos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductosStock {
    /**
     * Se utiliza la anotación Autowired para crear una instancia de StockMethods y así poder
     * utilizar los métodos definidos en la interfaz
     */
    @Autowired
    public StockMethods stockMethods;
    Producto guantes = new Producto(UUID.randomUUID().toString(),"Guantes", 20000);
    Producto pantaloneta = new Producto(UUID.randomUUID().toString(),"Pantaloneta", 10000);
    Producto guayos = new Producto(UUID.randomUUID().toString(),"Guayos", 50000);
    Producto medias = new Producto(UUID.randomUUID().toString(),"Medias", 5000);
    Producto espinillera = new Producto(UUID.randomUUID().toString(),"Espinillera", 6000);
    Producto camiseta = new Producto(UUID.randomUUID().toString(),"Camiseta", 15000);
    Producto camisilla = new Producto(UUID.randomUUID().toString(),"camisilla", 5000);
    Producto balon = new Producto(UUID.randomUUID().toString(),"Balón", 30000);
    Producto gorra = new Producto(UUID.randomUUID().toString(),"Gorra", 8000);
    Producto vendaje = new Producto(UUID.randomUUID().toString(),"Vendaje", 3000);

    public List<Producto> getStock(){
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

        // Se retorna la lista de productos en Stock
        return stockMethods.getListaStock();
    }
}
