package service.impl;

import controller.dto.ItemDTO;
import repository.model.Generactive;
import repository.model.Group;
import repository.model.Item;
import repository.model.Stock;
import service.GroupService;
import service.ItemService;
import utils.ApplicationContext;
import utils.Currency;

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
