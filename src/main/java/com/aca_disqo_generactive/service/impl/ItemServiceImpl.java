package com.aca_disqo_generactive.service.impl;

import com.aca_disqo_generactive.controller.dto.ItemDTO;
import com.aca_disqo_generactive.repository.model.Generactive;
import com.aca_disqo_generactive.repository.model.Group;
import com.aca_disqo_generactive.repository.model.Item;
import com.aca_disqo_generactive.repository.model.Stock;
import com.aca_disqo_generactive.service.GroupService;
import com.aca_disqo_generactive.service.ItemService;
import com.aca_disqo_generactive.utils.ApplicationContext;
import com.aca_disqo_generactive.utils.Currency;

public class ItemServiceImpl implements ItemService {

    private final GroupService groupService;

    public ItemServiceImpl() {
        this.groupService = new ApplicationContext().getGroupService();
    }

    @Override
    public Item create(ItemDTO itemDto) {
        final Item item = buildItemFrom(itemDto);
        Group group = groupService.get(item.getGroup().getId());
        group.getItems().add(item);
        return item;
    }


    private Item buildItemFrom(ItemDTO itemDTO) {
        Item item = null;
        if (itemDTO.getItemType() == 1) {
            item = new Generactive();
        } else if (itemDTO.getItemType() == 2) {
            item = new Stock();
        }
        assert item != null;
        item.setId(itemDTO.getId());
        item.setCurrency(convertCurrency(itemDTO.getCurrency()));
        item.setGroup(groupService.get(itemDTO.getGroupId()));
        item.setPrice(itemDTO.getPrice());
        item.setFinalPrice(item.calculatePrice(itemDTO.getPrice()));
        return item;
    }

    private Currency convertCurrency(String currencyType) {
        return Currency.valueOf(currencyType);
    }
}
