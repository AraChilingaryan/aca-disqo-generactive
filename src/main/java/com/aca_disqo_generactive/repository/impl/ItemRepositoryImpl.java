package com.aca_disqo_generactive.repository.impl;

import com.aca_disqo_generactive.container.Database;
import com.aca_disqo_generactive.repository.ItemRepository;
import com.aca_disqo_generactive.repository.model.Group;
import com.aca_disqo_generactive.repository.model.Item;
import com.aca_disqo_generactive.utils.ApplicationContext;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ItemRepositoryImpl implements ItemRepository {

    private static ItemRepository itemRepository = null;
    private final Database database;

    public ItemRepositoryImpl(Database database) {
        this.database = database;
    }

    public static ItemRepository getInstance() {
        if (itemRepository == null) {
            itemRepository = new ItemRepositoryImpl(ApplicationContext.getInstance().getDatabase());
        }
        return itemRepository;
    }

    @Override
    public Item create(Item item) {
        database.getItems().add(item);
        return database.getItems().get(database.getItems().size() - 1);
    }

    @Override
    public void deleteById(int id) {
        final Item item = database.getItems().stream()
                .filter(item1 -> item1.getId() == id)
                .findAny().get();
        database.getItems().remove(item);
    }

    @Override
    public List<Item> findItemByGroup(Group parentGroup) {
        return database.getItems().stream()
                .filter(item -> item.getGroup().equals(parentGroup))
                .collect(Collectors.toList());
    }

    @Override
    public Item findHighestPricedItem() {
        return database.getItems().stream().max(Comparator.comparingInt(Item::getBasePrice)).get();
    }
}
