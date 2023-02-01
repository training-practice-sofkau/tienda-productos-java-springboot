package com.sofkau.qa.tiendaproductos.Controller;

import com.sofkau.qa.tiendaproductos.Model.Orden;
import com.sofkau.qa.tiendaproductos.Model.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class OrdenController {

    /**@PostMapping("/compra")
    public ResponseEntity<Orden> purchase(@RequestBody PurchaseRequest request) {
        // create product
        Producto product = new Producto(request.getProductName(), request.getPrice(), request.getDiscount());
        // create order
        Orden orde = new Orden(request.getCustomerName(), product);
        // save order
        orden.save();
        // return response
        return ResponseEntity.ok(order);
    }**/

}
