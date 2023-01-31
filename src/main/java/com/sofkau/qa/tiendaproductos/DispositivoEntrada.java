package com.sofkau.qa.tiendaproductos;

public class DispositivoEntrada {
    private String tipoEntrada;
    private String marca;

    public DispositivoEntrada() {
    }

    public DispositivoEntrada(String tipoEntrada, String marca) {
        this.tipoEntrada = tipoEntrada;
        this.marca = marca;
    }

    public String tipoEntrada() {
        return tipoEntrada;
    }

    public DispositivoEntrada setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
        return this;
    }

    public String marca() {
        return marca;
    }

    public DispositivoEntrada setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    @Override
    public String toString() {
        return "DispositivoEntrada{" +
                "tipoEntrada='" + tipoEntrada + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
