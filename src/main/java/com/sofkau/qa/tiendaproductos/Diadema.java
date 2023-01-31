package com.sofkau.qa.tiendaproductos;

public class Diadema {
    private String tipoAudifono;

    public Diadema(String tipoAudifono) {
        this.tipoAudifono = tipoAudifono;
    }

    public String tipoAudifono() {
        return tipoAudifono;
    }

    public Diadema setTipoAudifono(String tipoAudifono) {
        this.tipoAudifono = tipoAudifono;
        return this;
    }

    @Override
    public String toString() {
        return
                "Tipo de Audifono: " + tipoAudifono ;
    }
}
