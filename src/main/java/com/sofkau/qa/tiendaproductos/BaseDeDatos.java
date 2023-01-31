package com.sofkau.qa.tiendaproductos;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class BaseDeDatos implements Produccion{
    private List<Factura> facturas;
    private Producto productos[];
    private BaseDeDatos() {
        this.facturas=new ArrayList<>();
        this.productos=new Producto[10];
    }
    public List<Factura> getFacturas(){
        return facturas;
    }
    public void addFacturas(Factura factura){
        this.facturas.add(factura);
    }
    public Producto[] getProductos(){
        return productos;
    }
    @Override
    public void addProducto(int posicion,Producto producto){
        this.productos[posicion]=producto;
    }

}
