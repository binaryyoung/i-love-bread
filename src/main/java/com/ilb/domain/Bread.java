package com.ilb.domain;

public class Bread {
    public String name;
    public String store;
    public int price;
    public boolean isChoco;

    public Bread() {}

    public Bread(String name, String store, int price, boolean isChoco) {
        this.name = name;
        this.store = store;
        this.price = price;
        this.isChoco = isChoco;
    }
}
