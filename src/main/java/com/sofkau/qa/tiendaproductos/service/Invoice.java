package com.sofkau.qa.tiendaproductos.service;

import com.sofkau.qa.tiendaproductos.Model.Product;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Invoice {
    private int id;
    private String fecha;
    private double importeTotal;

    private String cliente ;

    private String Factura;
    private String estado;
    private List<Product> products = Arrays.asList();

    public int getId() {
        return id;
    }

    public Invoice(double importeTotal, String estado, List<Product> products) {
        this.importeTotal = importeTotal + this.importeTotal;
        this.estado = estado;
        this.products = products;
    }

    public Invoice(List<Product> products) {
        this.products = products;
    }

    public Invoice(double importeTotal, String cliente, String factura, String estado, List<Product> products) {
        this.importeTotal = importeTotal;
        this.cliente = cliente;
        Factura = factura;
        this.estado = estado;
        this.products = products;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFactura() {
        return Factura;
    }

    public void setFactura(String factura) {
        Factura = factura;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Invoice() {
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Invoice(double importeTotal, String cliente, String estado, List<Product> products) {
        this.importeTotal = importeTotal;
        this.cliente = cliente;
        this.estado = estado;
        this.products = products;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String strDate = formatter.format(date);
        this.fecha= strDate;
    }

    @Override
    public String toString() {
        return "Factura  { " +
                "\n fecha =" + fecha +
                ",\n  cliente='" + cliente + '\'' +
                ",\n  estado='" + estado + '\'' +
                ",\n  productos=" + products +
                ",\n  importeTotal=" + importeTotal+"$ " +
                '}';
    }
}
