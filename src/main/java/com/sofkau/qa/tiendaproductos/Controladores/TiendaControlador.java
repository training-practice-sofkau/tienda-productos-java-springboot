package com.sofkau.qa.tiendaproductos.Controladores;

import com.sofkau.qa.tiendaproductos.Modelos.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/rest")
public class TiendaControlador {

    Stock miStock = new Stock();
    List<Factura>  listaFacturas= new ArrayList<>();

    @GetMapping("/bring/all")
    public Stock misproductos (){
        agregarProductos();
       return miStock;
    }
    private void agregarProductos(){
        miStock.agregarProducto("1", "Cuaderno", 2.500, 100);
        miStock.agregarProducto("2", "Lapiz", 1.000, 100);
        miStock.agregarProducto("3", "Reglas", 3.000, 100);
        miStock.agregarProducto("4", "Borrador", 600, 100);
        miStock.agregarProducto("5", "Carpeta", 4.500, 100);
        miStock.agregarProducto("6", "Marcadores", 1.800, 100);
        miStock.agregarProducto("7", "Colores", 8.000, 100);
        miStock.agregarProducto("8", "Tajalapiz", 800, 100);
        miStock.agregarProducto("9", "Foami", 1.600, 100);
        miStock.agregarProducto("10", "Cartulina", 1.200, 100);
    }


    @PutMapping ("/modificar")
    public Stock modificarPrecio(@RequestBody ProdCantidad prodCantidad){

        List<ProdCantidad> productos;
        productos= miStock.getMisProductos();
        for (ProdCantidad listaprod:productos) {
            if (listaprod.getId().equals(prodCantidad.getId())){
                listaprod.setPrecio(prodCantidad.getPrecio());
            }
        }
        return miStock;
    }


    @PostMapping("/factura")
    public ResponseEntity generarFactura(@RequestBody Cliente miCliente){
        Factura newFactura = new Factura(new Cliente(UUID.randomUUID().toString() ,miCliente.getNombre()));
        newFactura.setNit(UUID.randomUUID().toString());
        this.listaFacturas.add(newFactura);

        return new ResponseEntity(newFactura, HttpStatus.CREATED);
    }
    @PostMapping("/factura/{nit}")
    public Factura agregarProductosFactura(@PathVariable("nit") String nit, @RequestBody ProdCantidad prodCantidad ){
        ProdCantidad newProducto = new ProdCantidad(prodCantidad.getId(),prodCantidad.getNombre(),prodCantidad.getPrecio(),
                prodCantidad.getCantidad());
        Factura facturatemporal= new Factura();
        facturatemporal.setNit(nit);
        for (Factura mifactura:listaFacturas) {
            if (facturatemporal.getNumeroFactura().equals(mifactura.getNumeroFactura())){
                facturatemporal=mifactura;
                mifactura.agregarProductosFactura(newProducto);
            }
        }
        return facturatemporal;
    }

}
