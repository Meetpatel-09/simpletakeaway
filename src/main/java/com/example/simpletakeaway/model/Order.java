package com.example.simpletakeaway.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idorder;

    @Column
    private String order_item_name;

    @Column
    private double order_item_price;


    @Column
    private int order_item_quantity;


    @Column
    private Date order_date;


    @Column
    private double order_total;

    public int getIdorder() {
        return idorder;
    }

    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    public String getOrder_item_name() {
        return order_item_name;
    }

    public void setOrder_item_name(String order_item_name) {
        this.order_item_name = order_item_name;
    }

    public double getOrder_item_price() {
        return order_item_price;
    }

    public void setOrder_item_price(double order_item_price) {
        this.order_item_price = order_item_price;
    }

    public int getOrder_item_quantity() {
        return order_item_quantity;
    }

    public void setOrder_item_quantity(int order_item_quantity) {
        this.order_item_quantity = order_item_quantity;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public double getOrder_total() {
        return order_total;
    }

    public void setOrder_total(double order_total) {
        this.order_total = order_total;
    }
}
