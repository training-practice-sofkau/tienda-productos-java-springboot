package com.sofkau.qa.tiendaproductos;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;

public class Factura {
    @Autowired
    private Cliente cliente;
    private LocalDateTime fecha;
    private Producto producto;
}
