package com.sofkau.qa.tiendaproductos;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Store {

    private List<PurchaseOrder> purchaseOrdersList;


    public void HistoricalList(PurchaseOrder purchaseOrdersList) {
        ArrayList<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();
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
}
