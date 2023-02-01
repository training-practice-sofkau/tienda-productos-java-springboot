package com.rest.example.restexample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factura")
public class FacturaController {
    @GetMapping("/getfactura")
    public ResponseEntity getAllFacturas() {
        return new ResponseEntity(FacturasGuardadas.getFacturas(),HttpStatus.OK);
    }
    @PostMapping("/addfactura")
    public ResponseEntity<String> addFactura(@RequestBody Factura factura) {
        FacturasGuardadas.addFactura(factura);
        return new ResponseEntity<>("Factura agregada correctamente", HttpStatus.OK);
    }
}
