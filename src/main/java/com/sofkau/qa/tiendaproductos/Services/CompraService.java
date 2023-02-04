package com.sofkau.qa.tiendaproductos.Services;

import com.sofkau.qa.tiendaproductos.Model.Orden;
import com.sofkau.qa.tiendaproductos.Model.Producto;
import com.sofkau.qa.tiendaproductos.Repository.OrdenRepository;
import com.sofkau.qa.tiendaproductos.Repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CompraService  implements  ICompraService{
    @Autowired
    private ProductosRepository productosRepository;
    @Autowired
    private OrdenRepository ordenRepository;

    @Override
    public void registrarCompra(List<Producto> productosVendidos) {
    Orden nuevaOrden = new Orden(UUID.randomUUID().toString(),new Date().toString());
        nuevaOrden.setProductosComprados(productosVendidos);
        productosVendidos.stream().forEach(producto -> {
            productosRepository.disminuirStock(producto.getId());
        });
        ordenRepository.registrarVenta(nuevaOrden);

    }

    @Override
    public List<Orden> obtenerOrdenes() {
        return ordenRepository.obtenerFacturas();
    }
}
