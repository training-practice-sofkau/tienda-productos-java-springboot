package com.sofkau.qa.tiendaproductos;

public class Monitor {
    private final int idMonitor;
    private String tipoMonitor;
    private static int contadorMonitores;

    private Monitor(){
        this.idMonitor = ++Monitor.contadorMonitores;
    }

    public Monitor(String tipoMonitor) {
        this();
        this.tipoMonitor = tipoMonitor;
    }

    public String tipoMonitor() {
        return this.tipoMonitor;
    }

    public Monitor setTipoMonitor(String tipoMonitor) {
        this.tipoMonitor = tipoMonitor;
        return this;
    }


    public int idMonitor() {
        return this.idMonitor;
    }

    @Override
    public String toString() {
        return "{" +
                "Tipo de Monitor: " + tipoMonitor +
                '}';
    }
}
