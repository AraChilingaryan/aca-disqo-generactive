package com.aca_disqo_generactive.repository;

import com.aca_disqo_generactive.repository.model.Group;
import com.aca_disqo_generactive.repository.model.Item;

import java.util.List;

public interface ItemRepository {

    Item create(Item item);

    void deleteById(int id);

    List<Item> findItemByGroup(Group parentGroup);

    Item findHighestPricedItem();
}
