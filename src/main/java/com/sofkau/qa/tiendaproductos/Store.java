package com.sofkau.qa.tiendaproductos;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Store {

    private List<PurchaseOrder> purchaseOrdersList;
    private List<Product> productList;


    public Store(List<PurchaseOrder> purchaseOrdersList) {
        this.purchaseOrdersList = new ArrayList<PurchaseOrder>();
    }

    public void HistoricalList() {
       System.out.println("Lista de facturas ");
       this.purchaseOrdersList.stream().forEach(purchaseOrder -> {
           System.out.println( purchaseOrder.getId() + " " + purchaseOrder.getClient().getName() +
                    " " + purchaseOrder.getTotalAmount());
        });
    }

    public void addOrder(PurchaseOrder purchase){
        this.purchaseOrdersList.add(purchase);
    }

    public List<PurchaseOrder> getPurchaseOrdersList() {
        return purchaseOrdersList;
    }

    public void setPurchaseOrdersList(List<PurchaseOrder> purchaseOrdersList) {
        this.purchaseOrdersList = purchaseOrdersList;
    }


    @Override
    public String toString() {
        return "Store{" +
                "purchaseOrdersList=" + purchaseOrdersList +
                '}';
    }
}
