package com.aca_disqo_generactive.repository.model;

import com.aca_disqo_generactive.utils.Resolution;

public class Stock extends Item {

    @Override
    public double calculatePrice(int price) {
        return price * getResolutionValue();
    }

    @Override
    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int price) {
        finalPrice = calculatePrice(price);
    }


    private int getResolutionValue() {
        return Resolution.getResolutionValue(resolution);
    }
}
