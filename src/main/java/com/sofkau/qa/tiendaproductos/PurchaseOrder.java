package com.sofkau.qa.tiendaproductos;

import java.util.ArrayList;
import java.util.List;

public class PurchaseOrder {

    private static int id = 1;
    private Client client;
    private List<Product> productList;

    public PurchaseOrder() {
        this.id ++;
    }

  public void addProduct(Product product) {
      ArrayList<Product> products = new ArrayList<Product>();
  }
 public  void addClient(Client client){
        this.client = client;

 }


}
