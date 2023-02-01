package com.sofkau.qa.tiendaproductos.controller;


import com.sofkau.qa.tiendaproductos.Product;
import com.sofkau.qa.tiendaproductos.PurchaseOrder;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/store/")
public class StoreController {

    List<PurchaseOrder> purchaseOrders = new ArrayList<>();

    @GetMapping("/storeorders/all")
    public ResponseEntity getAllOrders(){
        return new ResponseEntity(purchaseOrders, HttpStatus.FOUND);
    }

    @PostMapping()
    public ResponseEntity createNewOrder(@RequestBody PurchaseOrder purchaseOrder){
        PurchaseOrder newPurchaseOrder = new PurchaseOrder(UUID.randomUUID().toString(),
                purchaseOrder.getId(),
                purchaseOrder.getDetailList(),
                purchaseOrder.getTotalAmount());
        this.purchaseOrders.add(newPurchaseOrder);
        return new ResponseEntity(newPurchaseOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{purchaseordersId}")
    public ResponseEntity updatePurchaseOrder(@PathVariable("purchaseId") String id, @RequestBody PurchaseOrder purchaseOrder){
        List<PurchaseOrder> newList = purchaseOrders.stream()
                .map(n -> n.getId().equals(id)?purchaseOrder:n).collect(Collectors.toList());
        this.purchaseOrders = newList;
        return new ResponseEntity( purchaseOrder , HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/{purchaseordersId}")
    public ResponseEntity deletepurchaseorders(@PathVariable("purchaseordersId") String id){
        List<PurchaseOrder> newPurchaseOrders = purchaseOrders.stream().filter(n -> !n.getId().equals(id)).collect(Collectors.toList());
        this.purchaseOrders = newPurchaseOrders;
        return new ResponseEntity(purchaseOrders, HttpStatus.GONE);
    }



}
