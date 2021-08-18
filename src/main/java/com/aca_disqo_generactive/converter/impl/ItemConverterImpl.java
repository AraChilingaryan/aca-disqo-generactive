package com.aca_disqo_generactive.converter.impl;

import com.aca_disqo_generactive.controller.dto.ItemDTO;
import com.aca_disqo_generactive.converter.ItemConverter;
import com.aca_disqo_generactive.repository.model.Item;

public class ItemConverterImpl implements ItemConverter {

    private static ItemConverter itemConverter;

    private ItemConverterImpl() {

    }

    public static ItemConverter getInstance() {
        if (itemConverter == null) {
            itemConverter = new ItemConverterImpl();
        }
        return itemConverter;
    }

    @Override
    public ItemDTO convert(final Item item) {
        final ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setGroupId(item.getGroup().getId());
        itemDTO.setCurrency(item.getCurrency().name());
        return itemDTO;
    }

    @Override
    public ItemDTO convertFromCSV(final String[] csvLine) {
        final ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(Integer.parseInt(csvLine[0]));
        itemDTO.setPrice(Integer.parseInt(csvLine[1]));
        itemDTO.setName(csvLine[2]);
        itemDTO.setImageUrl(csvLine[3]);
        itemDTO.setGroupId(Integer.parseInt(csvLine[4]));
        itemDTO.setCurrency("AMD");
        itemDTO.setItemType(1);
        return itemDTO;
    }
}
