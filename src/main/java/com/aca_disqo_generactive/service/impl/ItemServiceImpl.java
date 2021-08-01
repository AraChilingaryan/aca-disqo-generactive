package com.aca_disqo_generactive.service.impl;

import com.aca_disqo_generactive.controller.dto.GroupDTO;
import com.aca_disqo_generactive.controller.dto.ItemDTO;
import com.aca_disqo_generactive.repository.ItemRepository;
import com.aca_disqo_generactive.repository.model.Generative;
import com.aca_disqo_generactive.repository.model.Group;
import com.aca_disqo_generactive.repository.model.Item;
import com.aca_disqo_generactive.repository.model.Stock;
import com.aca_disqo_generactive.service.GroupService;
import com.aca_disqo_generactive.service.ItemService;
import com.aca_disqo_generactive.utils.ApplicationContext;
import com.aca_disqo_generactive.utils.Currency;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    private final GroupService groupService;
    private final ItemRepository itemRepository;
    private static ItemService itemService;

    private ItemServiceImpl(GroupService groupService1, ItemRepository itemRepository) {
        this.groupService = groupService1;
        this.itemRepository = itemRepository;
    }


    public static ItemService getInstance(){
        if (itemService == null) {
            itemService = new ItemServiceImpl(ApplicationContext.getInstance().getGroupService(),
                    ApplicationContext.getInstance().getItemRepository());
        }
        return itemService;
    }

    @Override
    public Item create(ItemDTO itemDto) {
        final Item item = buildItemFrom(itemDto);
        Group group = groupService.get(item.getGroup().getId());
        group.getItems().add(item);
        itemRepository.create(item);
        return item;
    }

    @Override
    public void deleteById(int id) {
        itemRepository.deleteById(id);
    }

    @Override
    public List<Item> findItemByGroup(int parentGroupId) {
        return itemRepository.findItemByGroup(groupService.get(parentGroupId));
    }

    @Override
    public Item findHighestPricedItem() {
        return itemRepository.findHighestPricedItem();
    }


    private Item buildItemFrom(ItemDTO itemDTO) {
        Item item = null;
        if (itemDTO.getItemType() == 1) {
            item = new Generative();
        } else if (itemDTO.getItemType() == 2) {
            item = new Stock();
        }
        assert item != null;
        item.setId(itemDTO.getId());
        item.setName(itemDTO.getName());
        item.setCurrency(convertCurrency(itemDTO.getCurrency()));
        item.setGroup(groupService.get(itemDTO.getGroupId()));
        item.setBasePrice(itemDTO.getPrice());
        return item;
    }

    private Currency convertCurrency(String currencyType) {
        return Currency.valueOf(currencyType);
    }
}
