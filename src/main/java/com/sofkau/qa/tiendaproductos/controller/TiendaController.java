package com.sofkau.qa.tiendaproductos.controller;

import com.sofkau.qa.tiendaproductos.Model.Product;
import com.sofkau.qa.tiendaproductos.service.Invoice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("api/tienda")
@RestController
public class TiendaController {
    Product Manzana = new Product("Manzana", 400, 1, 1);
    Product Pera = new Product("Pera", 450, 1, 2);
    Product durazno = new Product("Banano", 320, 1, 3);
    Product Naranja = new Product("Naranja", 370, 1, 4);
    Product Uva = new Product("Uva", 150, 1, 5);
    Product Kiwi = new Product("Kiwi", 120, 1, 6);
    Product Melón = new Product("Melón", 235, 1, 7);
    Product Fresa = new Product("Fresa", 356, 1, 8);
    Product Mango = new Product("Mango", 278, 1, 9);
    Product Papaya = new Product("Papaya", 356, 1, 10);
    List<Product> listProduct = Arrays.asList(Manzana, Pera, durazno, Naranja, Uva, Kiwi, Melón, Fresa, Mango, Papaya);
    List<Product> listProductNew = new ArrayList<>();
    List<Invoice> facturas = new ArrayList<>();
    @GetMapping
   public List<Product> getAllProduct(){
        if (listProductNew.size() == 0){
            listProductNew.addAll(listProduct);
        }
       return listProductNew;
   }
    @PostMapping
    public List<Product> postListProduct(@RequestBody List<Product> producstPost ){
        listProductNew.addAll(producstPost);
        return producstPost;
    }
    @GetMapping("/facturas")
    public  List<Invoice> getFacturas(){
        double varlorTotal= 0;
        if (listProductNew.size() == 0){
            listProductNew.addAll(listProduct);
        }
        for (Product item : listProductNew) {
            varlorTotal = item.valorTotal() + varlorTotal ;
        }
        facturas.add(new Invoice(varlorTotal,"Eros","pagado",listProductNew));
        facturas.add(new Invoice(varlorTotal,"Jose","pagado",listProductNew));
        return facturas;
    }
    @PostMapping("/producto")
    public ResponseEntity<Product> addProductNew(@RequestBody Product product){
        if (listProductNew.size() == 0){
            listProductNew.addAll(listProduct);
        }
        listProductNew.add(product);
        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<Product> putProduct(@RequestBody Product product ,@PathVariable int id){
        if (listProductNew.size() == 0){
            listProductNew.addAll(listProduct);
        }
        int idFormat = id - 1;
        listProductNew.set(idFormat,product);
        return  new ResponseEntity<>(listProductNew.get(idFormat), HttpStatus.OK);
    }
    @DeleteMapping("/producto/{id}")
    public ResponseEntity<Product> putProduct(@PathVariable int id){
        if (listProductNew.size() == 0){
            listProductNew.addAll(listProduct);
        }
        int idFormat = id - 1;
        Product Eliminado = listProductNew.remove(idFormat);

        if (Eliminado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Eliminado, HttpStatus.OK);
    }
}
