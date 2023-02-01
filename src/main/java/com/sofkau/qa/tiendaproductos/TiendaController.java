package com.sofkau.qa.tiendaproductos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/rest")
public class TiendaController {
    @GetMapping("/bring/productos")
    public ResponseEntity getTodosLosProductos(){
        return new ResponseEntity(Catalogo.getCatalogo().mostrarProductos(), HttpStatus.FOUND);
    }
    @GetMapping("/bring/facturas")
    public ResponseEntity getTodasLasFacturas(){
        return new ResponseEntity(BaseDeDatos.getBaseDeDatos().getFacturas(),HttpStatus.FOUND);
    }
    @PostMapping("/buy/producto")
    public ResponseEntity comprarProductos(@RequestBody HashMap<String,Object> compra){
        HashMap<String,Integer> productos=(HashMap<String, Integer>)compra.get("productos");
        HashMap<String,String> clienteMap=(HashMap<String, String>)compra.get("cliente");
        Cliente cliente=new Cliente(clienteMap.get("nombre"),clienteMap.get("id"));
        ArrayList<String> claves=new ArrayList<>(productos.keySet());
        ArrayList<Integer> valores=new ArrayList<>(productos.values());
        Tienda.getTienda().comprar(claves,valores,cliente);
        return new ResponseEntity(Catalogo.getCatalogo().mostrarProductos(),HttpStatus.ACCEPTED);
    }
    @PostMapping("/create/producto")
    public ResponseEntity creacionProducto(@RequestBody Producto producto){
        BaseDeDatos.getBaseDeDatos().addProducto(producto);
        return new ResponseEntity(Catalogo.getCatalogo().mostrarProductos(),HttpStatus.ACCEPTED);
    }
    @PutMapping("/modify/producto/{nombre}")
    public ResponseEntity modificacionProducto(@PathVariable("nombre") String nombre,@RequestBody Producto producto){
        ArrayList<Producto> productos= (ArrayList<Producto>) BaseDeDatos.getBaseDeDatos().getProductos().stream().map(producto1 -> producto1.getNombre().equalsIgnoreCase(nombre)?producto:producto1).collect(Collectors.toList());
        BaseDeDatos.getBaseDeDatos().setProductos(productos);
        return new ResponseEntity(Catalogo.getCatalogo().mostrarProducto(producto),HttpStatus.ACCEPTED);
    }
}
