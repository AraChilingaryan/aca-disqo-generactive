package com.aca_disqo_generactive.converter.impl;

import com.aca_disqo_generactive.controller.dto.ItemDTO;
import com.aca_disqo_generactive.converter.ItemConverter;
import com.aca_disqo_generactive.repository.model.Item;

public class ItemConverterImpl implements ItemConverter {

    @Override
    public ItemDTO convert(Item item) {
        final ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setGroupId(item.getGroup().getId());
        itemDTO.setCurrency(item.getCurrency().name());
        itemDTO.setFinalPrice(item.getFinalPrice());
        return itemDTO;
    }
}
