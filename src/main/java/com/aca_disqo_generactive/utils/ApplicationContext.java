package com.aca_disqo_generactive.utils;

import com.aca_disqo_generactive.container.Database;
import com.aca_disqo_generactive.controller.GroupController;
import com.aca_disqo_generactive.controller.ItemController;
import com.aca_disqo_generactive.converter.GroupConverter;
import com.aca_disqo_generactive.converter.ItemConverter;
import com.aca_disqo_generactive.converter.impl.GroupConverterImpl;
import com.aca_disqo_generactive.converter.impl.ItemConverterImpl;
import com.aca_disqo_generactive.repository.GroupRepository;
import com.aca_disqo_generactive.repository.ItemRepository;
import com.aca_disqo_generactive.repository.impl.GroupRepositoryImpl;
import com.aca_disqo_generactive.repository.impl.ItemRepositoryImpl;
import com.aca_disqo_generactive.service.GroupService;
import com.aca_disqo_generactive.service.ItemService;
import com.aca_disqo_generactive.service.impl.GroupServiceImpl;
import com.aca_disqo_generactive.service.impl.ItemServiceImpl;

public class ApplicationContext {

    private static ApplicationContext applicationContext = null;

    public static ApplicationContext getInstance() {
        if (applicationContext == null) {
            applicationContext = new ApplicationContext();
        }
        return applicationContext;
    }

    public GroupService getGroupService() {
        return GroupServiceImpl.getInstance();
    }

    public ItemService getItemService() {
        return ItemServiceImpl.getInstance();
    }

    public GroupController getGroupController() {
        return new GroupController(getGroupService(), getGroupConverter());
    }

    public ItemController getItemController() {
        return new ItemController(getItemService());
    }

    public GroupConverter getGroupConverter() {
        return GroupConverterImpl.getInstance();
    }

    public ItemConverter getItemConverter() {
        return ItemConverterImpl.getInstance();
    }

    public GroupRepository getGroupRepository() {
        return GroupRepositoryImpl.getInstance();
    }

    public ItemRepository getItemRepository() {
        return ItemRepositoryImpl.getInstance();
    }

    public Database getDatabase(){
        return Database.getInstance();
    }
}
