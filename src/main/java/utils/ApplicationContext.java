package utils;

import service.GroupService;
import service.ItemService;
import service.impl.GroupServiceImpl;
import service.impl.ItemServiceImpl;

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
