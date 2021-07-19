package com.aca_disqo_generactive.utils;

import com.aca_disqo_generactive.service.GroupService;
import com.aca_disqo_generactive.service.ItemService;
import com.aca_disqo_generactive.service.impl.GroupServiceImpl;
import com.aca_disqo_generactive.service.impl.ItemServiceImpl;

public class ApplicationContext {

    private GroupService groupService;
    private ItemService itemService;

    public GroupService getGroupService() {
        return new GroupServiceImpl();
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    public ItemService getItemService() {
        return new ItemServiceImpl();
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }
}
