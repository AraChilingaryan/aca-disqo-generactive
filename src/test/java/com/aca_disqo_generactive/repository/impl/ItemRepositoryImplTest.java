package com.aca_disqo_generactive.repository.impl;

import com.aca_disqo_generactive.context.ApplicationContext;
import com.aca_disqo_generactive.repository.GroupRepository;
import com.aca_disqo_generactive.repository.ItemRepository;
import com.aca_disqo_generactive.repository.model.Generative;
import com.aca_disqo_generactive.repository.model.Group;
import com.aca_disqo_generactive.repository.model.Item;
import com.aca_disqo_generactive.utils.Currency;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ItemRepositoryImplTest {

    private ItemRepository itemRepository = ApplicationContext.getInstance().getItemRepository();
    private GroupRepository groupRepository = ApplicationContext.getInstance().getGroupRepository();


    @Test
    public void createTestGroup() {
        final Group group = new Group();
        group.setId(1);
        group.setName("Marta");
        groupRepository.create(group);
        final Item item = new Generative();
        item.setBasePrice(1);
        item.setCurrency(Currency.AMD);
        item.setName("Items");
        item.setGroup(group);
        Assert.assertEquals(itemRepository.create(item).getGroup(), group);
    }

    @Test
    public void getTest() {
        final Group group = new Group();
        group.setId(1);
        group.setName("Marta");
        groupRepository.create(group);
        final Item item = new Generative();
        item.setBasePrice(100);
        item.setCurrency(Currency.AMD);
        item.setName("Items");
        item.setGroup(group);
        itemRepository.create(item);
        Assert.assertEquals(itemRepository.findItemByGroup(group).get(0), item);
    }

    @Test
    public void deleteTest() {
        final Group group = new Group();
        group.setId(1);
        group.setName("Marta");
        groupRepository.create(group);
        final Item item = new Generative();
        item.setBasePrice(100);
        item.setCurrency(Currency.AMD);
        item.setName("Items");
        item.setGroup(group);
        itemRepository.create(item);
        final Item item1 = new Generative();
        item1.setId(2);
        item.setName("It");
        item1.setGroup(group);
        item1.setCurrency(Currency.AMD);
        item1.setBasePrice(100);
        item1.setGroup(group);
        itemRepository.create(item1);
        itemRepository.deleteById(1);
        Assert.assertNotEquals(1, itemRepository.findItemByGroup(group).size());
    }


}
