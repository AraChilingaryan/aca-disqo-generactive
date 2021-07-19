package com.aca_disqo_generactive.repository.model;

import com.aca_disqo_generactive.utils.Currency;

public class Generactive extends Item {


    public Generactive() {
    }

    public Generactive(int id, Group group, double price, Currency currency) {
        super(id, group, price, currency);
    }

    @Override
    public double calculatePrice(int price) {
        return price;
    }
}
