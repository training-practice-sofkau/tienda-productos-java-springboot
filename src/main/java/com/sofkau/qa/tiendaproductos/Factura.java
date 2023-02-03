package com.sofkau.qa.tiendaproductos;

public class Factura {
    private int numero;
    private Instrumento instrumento;
    private Comprador comprador;

    public Factura (int numero, Instrumento instrumento,Comprador comprador){
        this.numero=numero;
        this.comprador=comprador;
        this.instrumento=instrumento;
    }

    public int darNumero(){
        return numero;
    }
    public Comprador darComprador(){
        return comprador;
    }
    public Instrumento darInstrumento(){
        return instrumento;
    }

}
