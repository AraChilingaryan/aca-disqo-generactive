package com.aca_disqo_generactive.utils;

import com.aca_disqo_generactive.controller.GroupController;
import com.aca_disqo_generactive.controller.ItemController;
import com.aca_disqo_generactive.converter.GroupConverter;
import com.aca_disqo_generactive.converter.ItemConverter;
import com.aca_disqo_generactive.converter.impl.GroupConverterImpl;
import com.aca_disqo_generactive.converter.impl.ItemConverterImpl;
import com.aca_disqo_generactive.service.GroupService;
import com.aca_disqo_generactive.service.ItemService;
import com.aca_disqo_generactive.service.impl.GroupServiceImpl;
import com.aca_disqo_generactive.service.impl.ItemServiceImpl;

public class ApplicationContext {

    private GroupController groupController;
    private ItemController itemController;
    private GroupService groupService;
    private ItemService itemService;
    private GroupConverter groupConverter;
    private ItemConverter itemConverter;

    public GroupService getGroupService() {
        return new GroupServiceImpl();
    }

    public ItemService getItemService() {
        return new ItemServiceImpl();
    }

    public GroupController getGroupController() {
        return new GroupController(getGroupService(), getGroupConverter());
    }

    public ItemController getItemController() {
        return new ItemController(getItemService(), getItemConverter());
    }

    public GroupConverter getGroupConverter() {
        return new GroupConverterImpl(itemConverter);
    }

    public ItemConverter getItemConverter() {
        return new ItemConverterImpl();
    }
}
