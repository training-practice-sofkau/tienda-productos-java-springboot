package com.sofkau.qa.tiendaproductos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Catalogo implements Produccion{
    private static Catalogo catalogo=null;

    public static Catalogo getCatalogo(){
        if(catalogo==null)
            return new Catalogo();
        return catalogo;
    }

    private Catalogo(){
        addProducto(new ProductoBuilder()
                .nombre("Sarten Antiadherente")
                .cantidad(10)
                .precio(50000)
                .descripcion("Sarten de acero inoxidable con revestimiento antiadherente.").build());
        addProducto(new ProductoBuilder()
                .nombre("Batidora de Mano")
                .cantidad(15)
                .precio(70000)
                .descripcion("Batidora eléctrica con potencia de 300W y varillas de acero inoxidable.").build());
        addProducto(new ProductoBuilder()
                .nombre("Olla a Presión")
                .cantidad(5)
                .precio(90000)
                .descripcion("Olla con capacidad de 6 litros y sistema de seguridad de válvula.").build());
        addProducto(new ProductoBuilder()
                .nombre("Tostadora de Pan")
                .cantidad(20)
                .precio(40000)
                .descripcion("Tostadora con ajuste de temperatura y bandeja recolectora de migas.").build());
        addProducto(new ProductoBuilder()
                .nombre("Licuadora")
                .cantidad(10)
                .precio(80000)
                .descripcion("Licuadora con potencia de 600W y vaso de vidrio de 1,5 litros.").build());
        addProducto(new ProductoBuilder()
                .nombre("Exprimidor Eléctrico")
                .cantidad(15)
                .precio(60000)
                .descripcion("Exprimidor eléctrico con filtro de pulpa y capacidad de 1 litro.").build());
        addProducto(new ProductoBuilder()
                .nombre("Cafetera Automática")
                .cantidad(5)
                .precio(150000)
                .descripcion("Cafetera con capacidad de 1,5 litros y programador de encendido.").build());
        addProducto(new ProductoBuilder()
                .nombre("Ollas y Sartenes Set")
                .cantidad(3)
                .precio(200000)
                .descripcion(" Juego de ollas y sartenes de acero inoxidable con revestimiento antiadherente.").build());
        addProducto(new ProductoBuilder()
                .nombre("Plancha de Asar")
                .cantidad(10)
                .precio(100000)
                .descripcion("Plancha con revestimiento antiadherente y control de temperatura ajustable.").build());
        addProducto(new ProductoBuilder()
                .nombre("Microondas")
                .cantidad(5)
                .precio(150000)
                .descripcion("Microondas con capacidad de 20 litros y programas de cocción automáticos.").build());
    }
    @Override
    public void addProducto(Producto producto){
        BaseDeDatos.getBaseDeDatos().addProducto(producto);
    }
    public void mostrarProducto(int producto){
        Producto impresion=BaseDeDatos.getBaseDeDatos().getProductos().get(producto);
        System.out.println("Nombre: "+impresion.getNombre()+
                "\nCantidad disponible: "+impresion.getCantidad()+
                "\nPrecio: "+impresion.getPrecio()+
                "\nDescripción: "+impresion.getDescripcion());
    }
    public List<Producto> mostrarProductos(){
        return BaseDeDatos.getBaseDeDatos().getProductos();
    }
    public void mostrarProductosAComprar(){
        int i=0;
        for(Producto producto:BaseDeDatos.getBaseDeDatos().getProductos()){
            i++;
            System.out.println(i+" Nombre: "+producto.getNombre());
        }
        System.out.println();
    }
}
