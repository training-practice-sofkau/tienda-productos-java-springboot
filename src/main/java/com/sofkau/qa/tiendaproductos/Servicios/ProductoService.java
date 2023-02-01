package com.sofkau.qa.tiendaproductos.Servicios;


import com.sofkau.qa.tiendaproductos.Modelos.Producto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductoService {

    private final AtomicLong idCounter = new AtomicLong();
    private List<Producto> productos = new ArrayList<>();

    public Producto agregarProducto(Producto producto) {
        producto.setId(idCounter.incrementAndGet());
        productos.add(producto);
        return producto;
    }

    public List<Producto> obtenerProductos() {
        return productos;
    }


    public Producto actualizarProducto(Long id, Producto producto) throws ProductoNoEncontradoException {
        Producto productoExistente = productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setStock(producto.getStock());
        return productoExistente;
    }

    public Producto obtenerProductoPorId(Long id) throws ProductoNoEncontradoException {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        throw new ProductoNoEncontradoException(id);
    }

    public void borrarProducto(Long id) {
        productos.removeIf(p -> p.getId().equals(id));
    }
}


