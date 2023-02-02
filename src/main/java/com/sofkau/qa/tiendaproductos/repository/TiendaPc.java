package com.sofkau.qa.tiendaproductos.repository;

import com.sofkau.qa.tiendaproductos.repository.domain.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TiendaPc {
    private final String nombbreTienda = "mundoPc";
    private List<Producto> productos;
    private int valorArticulo;

    public TiendaPc() {
        productos = new ArrayList<>(List.of(new Producto("1", "Teclado", 30.000, 20),
                new Producto("2", "Mause", 20.000, 15),
                new Producto("3", "Monitor", 200.000, 55),
                new Producto("4", "Audifo", 50.000, 25),
                new Producto("5", "Memoria Ram", 220.000, 15),
                new Producto("6", "Cámara Web", 65.000, 5),
                new Producto("7", "Parlante", 70.000, 15),
                new Producto("8", "Disco Duro", 250.000, 15),
                new Producto("9", "Portati HP", 700.000, 10),
                new Producto("10", "Memoria USB", 40.000, 15)
        ));
    }

    public TiendaPc setValorArticulo(int valorArticulo) {
        this.valorArticulo = valorArticulo;
        return this;
    }

    public void reducirArticulosAlmacen(String id){
        List<Producto> resultado = productos.stream().map(producto -> {
            if (producto.getId().equals(id)){
                producto.reducirArticulosAlmacen();
                return producto;
            }
            return producto;
        }).collect(Collectors.toList());

    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }
    public List<Producto> getProductos(){
        return productos;
    }
    public void setProductos(List<Producto> productos){
        this.productos = productos;
    }
    @Override
    public String toString() {
        return "TiendaPc{" +
                "nombbreTienda='" + nombbreTienda + '\'' +
                ", productos=" + productos +
                ", valorArticulo=" + valorArticulo +
                '}';
    }
}
