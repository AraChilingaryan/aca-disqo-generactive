package com.aca_disqo_generactive.controller;

import com.aca_disqo_generactive.controller.dto.ItemDTO;
import com.aca_disqo_generactive.repository.model.Item;
import com.aca_disqo_generactive.service.ItemService;

import java.util.List;

public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    public Item create(ItemDTO itemDto) {
        return itemService.create(itemDto);
    }

    public void delete(int id) {
        itemService.deleteById(id);
    }

    public List<Item> getItemsByGroup(int parentId) {
        return itemService.findItemByGroup(parentId);
    }

    public Item findHighestPricedItem() {
        return itemService.findHighestPricedItem();
    }
}
