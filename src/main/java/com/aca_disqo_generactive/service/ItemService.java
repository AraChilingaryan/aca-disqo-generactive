package com.aca_disqo_generactive.service;

import com.aca_disqo_generactive.controller.dto.ItemDTO;
import com.aca_disqo_generactive.repository.model.Group;
import com.aca_disqo_generactive.repository.model.Item;

import java.util.List;

public interface ItemService {

    Item create(ItemDTO itemDto);

    void deleteById(int id);

    List<Item> findItemByGroup(int parentGroupId);

    Item findHighestPricedItem();

}
