package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.List;




public class PurchaseOrder {

    private String id;
    private Client client;

    private List<Detail> detailList;
    private double totalAmount;


    public PurchaseOrder(String id, Client client) {
         this.id= id;
        this.client = client;
        this.detailList = new ArrayList<Detail>();



    }



    public void addProduct(String id, Product product, int quantity) {
        double cacularAmount = product.getPrice() * quantity;
        Detail  detalle =  new Detail(id, product, quantity, cacularAmount);
       this.detailList.add(detalle);
       this.totalAmount = cacularAmount +totalAmount;
    }



    public  void addClient(Client client){
        this.client = client;

 }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public List<Detail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Detail> detailList) {
        this.detailList = detailList;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }




    public void orderPrint() {
        System.out.println(" Número de Factura: " + this.getId() + " \n nombre de cliente:  " + this.getClient().toString());
        System.out.println("----------------------------------------------------------------");
        System.out.println("Producto                Precio            Cantidad           Total"  );
        System.out.println("----------------------------------------------------------------");
        this.detailList.stream().forEach(detail -> {
            System.out.println( detail.getProduct().toString() + "  " + detail.getProduct().getPrice() + " " + detail.getQuantity() +
                            " " + detail.getAmount());

        });
        System.out.println("----------------------------------------------------------------");
        System.out.println("Total:        " + this.getTotalAmount());



    }
}
