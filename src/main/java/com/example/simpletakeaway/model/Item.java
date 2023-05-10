package com.example.simpletakeaway.model;

import jakarta.persistence.*;

@Entity
@Table (name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int iditem;

    @Column
    private String item_name;

    @Column
    private float item_price;

    public int getIditem() {
        return iditem;
    }

    public void setIditem(int iditem) {
        this.iditem = iditem;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public float getItem_price() {
        return item_price;
    }

    public void setItem_price(float item_price) {
        this.item_price = item_price;
    }

    public Item() {
    }

    public Item(int iditem, String item_name, float item_price) {
        this.iditem = iditem;
        this.item_name = item_name;
        this.item_price = item_price;
    }
}
