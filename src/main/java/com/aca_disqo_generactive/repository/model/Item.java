package com.aca_disqo_generactive.repository.model;

import com.aca_disqo_generactive.utils.Currency;
import com.aca_disqo_generactive.utils.Resolution;

public abstract class Item {

    protected int id;
    protected Group group;
    protected double price;
    protected Currency currency;
    protected double finalPrice;

    public Item() {
    }

    public Item(int id, Group group, double price, Currency currency) {
        this.id = id;
        this.group = group;
        this.price = price;
        this.currency = currency;
    }

    public abstract double calculatePrice(int price);

    public Resolution chooseResolution(String choice){
       return Resolution.valueOf(choice);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }
}
