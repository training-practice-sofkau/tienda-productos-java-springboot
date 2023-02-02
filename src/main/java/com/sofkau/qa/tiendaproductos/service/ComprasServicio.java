package com.sofkau.qa.tiendaproductos.service;

import com.sofkau.qa.tiendaproductos.repository.FacturaRepository;
import com.sofkau.qa.tiendaproductos.repository.TiendaPc;
import com.sofkau.qa.tiendaproductos.repository.domain.Factura;
import com.sofkau.qa.tiendaproductos.repository.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ComprasServicio implements IComprasService{

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private TiendaPc tiendaPc;

    @Override
    public void registrarCompra(List<Producto> productosVendidos) {
        Factura nuevaFactura = new Factura(UUID.randomUUID().toString(), new Date().toString());
        nuevaFactura.setProductos(productosVendidos);
        productosVendidos.stream().forEach(producto -> {
            tiendaPc.reducirArticulosAlmacen(producto.getId());
        });
        facturaRepository.registrarVenta(nuevaFactura);

    }

    @Override
    public List<Factura> mostrarFacturas() {
        return facturaRepository.mostrarFacturas();
    }
}
