package com.aca_disqo_generactive.repository.model;

import com.aca_disqo_generactive.utils.Currency;
import com.aca_disqo_generactive.utils.Resolution;

public class Generactive extends Item {

    private int complexity;
    private Resolution resolution;


    public Generactive() {
    }

    public Generactive(int id, Group group, double price, Currency currency) {
        super(id, group, price, currency);
    }

    @Override
    public double calculatePrice(int price) {
        finalPrice = price * getResolutionValue(resolution) * complexity;
        return finalPrice;
    }

    private int getResolutionValue(Resolution resolution){
        return Resolution.getResolutionValue(resolution);
    }

}
