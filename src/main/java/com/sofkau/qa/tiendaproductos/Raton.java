package com.sofkau.qa.tiendaproductos;

public class Raton {
    private final int idRaton;
    private  static int contadorRaton;
    private String tipoMause;

    public Raton(String tipoMause) {
        this.idRaton = ++Raton.contadorRaton;
        this.tipoMause = tipoMause;
    }

    public String tipoMause() {
        return tipoMause;
    }

    public Raton setTipoMause(String tipoMause) {
        this.tipoMause = tipoMause;
        return this;
    }

    @Override
    public String toString() {
        return "{"+ "Tipo de mause: " + this.tipoMause +
                '}';
    }
}
