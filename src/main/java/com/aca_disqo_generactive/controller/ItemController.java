package com.aca_disqo_generactive.controller;

import com.aca_disqo_generactive.controller.dto.ItemDTO;
import com.aca_disqo_generactive.repository.model.Item;
import com.aca_disqo_generactive.service.ItemService;
import com.aca_disqo_generactive.service.impl.ItemServiceImpl;

public class ItemController {

    private final ItemService itemService;

    public ItemController() {
        this.itemService = new ItemServiceImpl();
    }

    public Item create(ItemDTO itemDto) {
         return itemService.create(itemDto);
    }
}
