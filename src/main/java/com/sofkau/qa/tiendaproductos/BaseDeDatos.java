package com.sofkau.qa.tiendaproductos;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class BaseDeDatos implements Produccion{
    private static BaseDeDatos baseDeDatos=null;
    private List<Factura> facturas;
    private List<Producto> productos;
    private BaseDeDatos() {
        this.facturas=new ArrayList<>();
        this.productos=new ArrayList<>();
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
