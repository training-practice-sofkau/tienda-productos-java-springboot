package com.sofkau.qa.tiendaproductos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("api/v1/rest")
public class TiendaController {
    @GetMapping()
    public ResponseEntity getAllProducts(){
        return new ResponseEntity(Catalogo.getCatalogo().mostrarProductos(), HttpStatus.FOUND);
    }
}
