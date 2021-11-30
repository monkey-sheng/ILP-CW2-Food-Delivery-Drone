package uk.ac.ed.inf;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class DeliveryOrder {
    public String orderNo;
    public Date deliveryDate;
    public String customer;  // matriculation string
    public String deliverTo;  //w3w string
    List<String> items;
    public LongLat pickup1 = null, pickup2 = null;  // can be from 2 stores max
    public LongLat deliveryLngLat;
    public int totalCost;
    
    public DeliveryOrder(String orderNo, Date deliveryDate, String customer, String deliverTo,
                         DBManager dbManager, Menus menus, What3Words what3Words) {
        this.orderNo = orderNo;
        this.deliveryDate = deliveryDate;
        this.customer = customer;
        this.deliverTo = deliverTo;
        this.deliveryLngLat = what3Words.getLongLatFromWords(deliverTo);
        this.items = dbManager.getOrderItemsForNo(orderNo);
        this.totalCost = menus.getDeliveryCost(items);
        List<String> locations = menus.getItemsLocations(items);
        this.pickup1 = what3Words.getLongLatFromWords(locations.get(0));
        if (locations.size() == 2) {
            this.pickup2 = what3Words.getLongLatFromWords(locations.get(1));
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryOrder order = (DeliveryOrder) o;
        return orderNo.equals(order.orderNo);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(orderNo, deliveryDate, customer, deliverTo, items, pickup1, pickup2, deliveryLngLat, totalCost);
    }
}
