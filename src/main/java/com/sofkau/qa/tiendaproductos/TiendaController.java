package com.sofkau.qa.tiendaproductos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("api/v1/rest")
public class TiendaController {
    @GetMapping("/bring/productos")
    public ResponseEntity getAllProducts(){
        return new ResponseEntity(Catalogo.getCatalogo().mostrarProductos(), HttpStatus.FOUND);
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
}
