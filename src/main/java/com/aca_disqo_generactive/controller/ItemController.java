package com.aca_disqo_generactive.controller;

import com.aca_disqo_generactive.controller.dto.ItemDTO;
import com.aca_disqo_generactive.converter.ItemConverter;
import com.aca_disqo_generactive.repository.model.Item;
import com.aca_disqo_generactive.service.ItemService;

public class ItemController {

    private final ItemService itemService;
    private final ItemConverter itemConverter;

    public ItemController(ItemService itemService, ItemConverter itemConverter) {
        this.itemService = itemService;
        this.itemConverter = itemConverter;
    }

    public ItemDTO create(ItemDTO itemDto) {
         return itemConverter.convert(itemService.create(itemDto));
    }
}
