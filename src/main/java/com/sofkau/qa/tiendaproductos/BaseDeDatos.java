package com.sofkau.qa.tiendaproductos;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class BaseDeDatos implements Produccion{
    private static BaseDeDatos baseDeDatos=null;
    private List<Factura> facturas=new ArrayList<>();
    private List<Producto> productos= Arrays.asList(new ProductoBuilder().nombre("Sarten Antiadherente")
            .cantidad(10).precio(50000).descripcion("Sarten de acero inoxidable con revestimiento antiadherente.").build(),
            new ProductoBuilder().nombre("Batidora de Mano").cantidad(15)
                    .precio(70000).descripcion("Batidora eléctrica con potencia de 300W y varillas de acero inoxidable.").build(),
            new ProductoBuilder().nombre("Olla a Presión").cantidad(5)
                    .precio(90000).descripcion("Olla con capacidad de 6 litros y sistema de seguridad de válvula.").build(),
            new ProductoBuilder().nombre("Tostadora de Pan").cantidad(20)
                    .precio(40000).descripcion("Tostadora con ajuste de temperatura y bandeja recolectora de migas.").build(),
            new ProductoBuilder().nombre("Licuadora")
                    .cantidad(10).precio(80000).descripcion("Licuadora con potencia de 600W y vaso de vidrio de 1,5 litros.").build(),
            new ProductoBuilder().nombre("Exprimidor Eléctrico")
                    .cantidad(15).precio(60000).descripcion("Exprimidor eléctrico con filtro de pulpa y capacidad de 1 litro.").build(),
            new ProductoBuilder().nombre("Cafetera Automática")
                    .cantidad(5).precio(150000).descripcion("Cafetera con capacidad de 1,5 litros y programador de encendido.").build(),
            new ProductoBuilder().nombre("Ollas y Sartenes Set")
                    .cantidad(3).precio(200000).descripcion(" Juego de ollas y sartenes de acero inoxidable con revestimiento antiadherente.").build(),
            new ProductoBuilder().nombre("Plancha de Asar")
                    .cantidad(10).precio(100000).descripcion("Plancha con revestimiento antiadherente y control de temperatura ajustable.").build(),
            new ProductoBuilder().nombre("Microondas")
                    .cantidad(5).precio(150000).descripcion("Microondas con capacidad de 20 litros y programas de cocción automáticos.").build());
    private BaseDeDatos() {
    }
    public static BaseDeDatos getBaseDeDatos(){
        if(baseDeDatos==null)
            baseDeDatos=new BaseDeDatos();
        return baseDeDatos;
    }
    public List<Factura> getFacturas(){
        return facturas;
    }
    public void addFacturas(Factura factura){
        this.facturas.add(factura);
    }
    public List<Producto> getProductos(){
        return productos;
    }
    @Override
    public void addProducto(Producto producto){
        this.productos.add(producto);
    }

}
