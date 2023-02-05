package com.sofkau.qa.tiendaproductos.Repository;

import com.sofkau.qa.tiendaproductos.Model.Orden;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class OrdenRepository {
    private List<Orden> ordenList;

    public OrdenRepository(){
        this.ordenList = new ArrayList<>();
    }

    public void registrarVenta(Orden orden){
        ordenList.add(orden);
    }

    public List<Orden> obtenerFacturas(){
        return this.ordenList;
    }
}
