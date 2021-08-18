package com.aca_disqo_generactive.repository.impl;

import com.aca_disqo_generactive.context.ApplicationContext;
import com.aca_disqo_generactive.repository.GroupRepository;
import com.aca_disqo_generactive.repository.ItemRepository;
import com.aca_disqo_generactive.repository.model.Generative;
import com.aca_disqo_generactive.repository.model.Group;
import com.aca_disqo_generactive.repository.model.Item;
import com.aca_disqo_generactive.utils.Currency;
import org.junit.Assert;
import org.junit.Test;

public class GroupRepositoryImplTest {

    private ItemRepository itemRepository = ApplicationContext.getInstance().getItemRepository();
    private GroupRepository groupRepository = ApplicationContext.getInstance().getGroupRepository();

    @Test
    public void createGroupTest() {
        final Group group = new Group();
        group.setId(1);
        group.setName("Test");
        groupRepository.create(group);
        Assert.assertEquals(group, groupRepository.findGroupByName("Test"));

        final Item item = new Generative();
        item.setId(1);
        item.setBasePrice(1);
        item.setCurrency(Currency.AMD);
        item.setName("Items");
        item.setGroup(group);
        itemRepository.create(item);
        Assert.assertEquals(groupRepository.findGroupByName("Test"),
                itemRepository.findHighestPricedItem().getGroup());
    }

    @Test
    public void getGroupTest(){
        final Group group = new Group();
        group.setId(1);
        group.setName("Test");
        groupRepository.create(group);
        final Group group1 = new Group();
        group1.setId(2);
        group1.setName("Test1");
        groupRepository.create(group1);
        Assert.assertEquals(group1, groupRepository.get(2));
        Assert.assertEquals(group, groupRepository.get(1));
    }

    @Test
    public void getAllTest(){
        final Group group = new Group();
        group.setId(1);
        group.setName("Test");
        groupRepository.create(group);
        final Group group1 = new Group();
        group1.setId(2);
        group1.setName("Test1");
        groupRepository.create(group1);
        Assert.assertEquals(group1, groupRepository.getAll().get(1));
        Assert.assertEquals(group, groupRepository.getAll().get(0));
    }

    @Test
    public void deleteByIdTest(){
        final Group group = new Group();
        group.setId(1);
        group.setName("Test");
        groupRepository.create(group);
        final Group group1 = new Group();
        group1.setId(2);
        group1.setName("Test1");
        groupRepository.create(group1);
        groupRepository.deleteById(1);
        Assert.assertEquals(1, groupRepository.getAll().size());
    }

    @Test
    public void findGroupByNameTest(){
        final Group group = new Group();
        group.setId(1);
        group.setName("Test");
        groupRepository.create(group);
        final Group group1 = new Group();
        group1.setId(2);
        group1.setName("Test1");
        groupRepository.create(group1);
        Assert.assertEquals(group1, groupRepository.findGroupByName("Test1"));
        Assert.assertEquals(group, groupRepository.findGroupByName("Test"));
    }
}
