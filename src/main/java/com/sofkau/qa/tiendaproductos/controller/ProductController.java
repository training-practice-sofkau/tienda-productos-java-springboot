package com.sofkau.qa.tiendaproductos.controller;

import com.sofkau.qa.tiendaproductos.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/v1/store")
public class ProductController {

    List<Product> productList = new ArrayList<>();

    @GetMapping("/products/all")
    public ResponseEntity getListProducts(){
        return new ResponseEntity(productList, HttpStatus.FOUND);
    }
    @PostMapping()
    public ResponseEntity createProduct(@RequestBody Product product){
        Product newProduct = new Product(UUID.randomUUID().toString(),
        product.getName(),
        product.getDescription(),
        product.getPrice(),
        product.getStock());
       this.productList.add(newProduct);
        return new ResponseEntity(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity updateProduct(@PathVariable("productId") String id,
                                     @RequestBody Product product){
        List<Product> newList = productList.stream()
                .map(n -> n.getId().equals(id)?product:n).collect(Collectors.toList());

        this.productList = newList;
        return new ResponseEntity(product, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity deleteProduct(@PathVariable("productId") String id){
        List<Product> newList = productList.stream().filter(n -> !n.getId().equals(id)).collect(Collectors.toList());
        this.productList = newList;
        return new ResponseEntity(productList, HttpStatus.GONE);
    }

}

