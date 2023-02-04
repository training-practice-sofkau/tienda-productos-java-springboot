package com.sofkau.qa.tiendaproductos.Repository;

import com.sofkau.qa.tiendaproductos.Model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductosRepository {
    private final String nombre;
    private List<Producto> productos;

    public ProductosRepository() {
        this.nombre = "MiTienda";
        productos = new ArrayList<>(List.of(new Producto("1", "Blusa", "Color Azul", 23000.0, 4),
                new Producto("2", "Jean", "Color negro", 53000.0, 5),
                new Producto("3", "Camisa", "Color Rosa, talla s", 33000.0, 4)));
    }

    public void disminuirStock(String id){
        List<Producto> resultado = productos.stream().map(producto -> {
            if(producto.getId().equals(id)){
                producto.disminuirStock();
                return producto;
            }
                return producto;
        }).collect(Collectors.toList());
    }
     public List<Producto> mostrarProductos(){
        return productos;
     }

}
