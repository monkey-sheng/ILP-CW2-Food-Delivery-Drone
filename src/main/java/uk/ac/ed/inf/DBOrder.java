package uk.ac.ed.inf;

import java.sql.Date;

public class DBOrder {
    public String orderNo;
    public Date deliveryDate;
    public String customer;
    public String deliverTo;
    
    public DBOrder(String orderNo, Date deliveryDate, String customer, String deliverTo) {
        this.orderNo = orderNo;
        this.deliveryDate = deliveryDate;
        this.customer = customer;
        this.deliverTo = deliverTo;
    }
}