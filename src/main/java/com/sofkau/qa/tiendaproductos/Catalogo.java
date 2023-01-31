package com.sofkau.qa.tiendaproductos;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class
Catalogo {
    public List<Producto> productosList;

    public Catalogo(List<Producto> productosList) {
        this.productosList = productosList;
    }

    public Catalogo() {
        this.productosList = new ArrayList<>();
    }

    public void mostrarCatalogo(){
        productosList.stream().forEach(productoList -> {
            System.out.println("Producto" + productoList.getNombre());
        });


    }

    public void addProductoaCatalogo(Producto producto){
        productosList.add(producto);

    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "productosList=" + productosList +
                '}';
    }
}
