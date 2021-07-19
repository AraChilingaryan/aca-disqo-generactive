package controller;

import controller.dto.ItemDTO;
import repository.model.Item;
import service.ItemService;
import service.impl.ItemServiceImpl;

public class ItemController {

    private final ItemService itemService;

    public ItemController() {
        this.itemService = new ItemServiceImpl();
    }

    public Item create(ItemDTO itemDto) {
         return itemService.create(itemDto);
    }
}
