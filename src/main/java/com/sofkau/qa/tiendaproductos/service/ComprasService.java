package com.sofkau.qa.tiendaproductos.service;

import com.sofkau.qa.tiendaproductos.repository.FacturaRepository;
import com.sofkau.qa.tiendaproductos.repository.TiendaDonJose;
import com.sofkau.qa.tiendaproductos.repository.models.Factura;
import com.sofkau.qa.tiendaproductos.repository.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ComprasService implements IComprasService{

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private TiendaDonJose tiendaDonJose;
    @Override
    public void registrarCompra(List<Producto> productosComprados) {
        Factura nuevaFactura = new Factura(UUID.randomUUID().toString(), new Date().toString());
        nuevaFactura.setProductos(productosComprados);
        productosComprados.stream().forEach(producto -> {
            tiendaDonJose.disminuirStock(producto.getId());
        });
        facturaRepository.registrarVenta(nuevaFactura);
    }

    @Override
    public List<Factura> obtenerFacturas() {
        return facturaRepository.obtenerFacturas();
    }
}
