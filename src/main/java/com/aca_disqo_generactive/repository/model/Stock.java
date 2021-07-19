package com.aca_disqo_generactive.repository.model;

public class Stock extends Item{

    @Override
    public double calculatePrice(int price) {
        return price;
    }
}
