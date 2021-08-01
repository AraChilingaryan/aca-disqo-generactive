package com.aca_disqo_generactive.repository.model;

import com.aca_disqo_generactive.config.Configuration;
import com.aca_disqo_generactive.utils.Resolution;

public class Stock extends Item {

    public Stock() {
    }

    public Stock(int id, int basePrice, String name) {
        super(id, basePrice, name);
    }


    @Override
    public double calculatePrice(Configuration configuration) {
        return getBasePrice() * configuration.getResolution().getCoefficient();
    }
}
