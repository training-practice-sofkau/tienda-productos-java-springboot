package com.sofkau.qa.tiendaproductos;

public class PruebaMain {
    public static void main(String[] args) {
        ShopPc prueba = new ShopPc();
        prueba.tienda();

        Producto dos = new Producto();
         Orden uno = new Orden();
          uno.mostrarOrden();
    }

}