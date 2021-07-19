package com.aca_disqo_generactive;

import com.aca_disqo_generactive.controller.dto.GroupDTO;
import com.aca_disqo_generactive.controller.dto.ItemDTO;
import com.aca_disqo_generactive.service.GroupService;
import com.aca_disqo_generactive.service.ItemService;
import com.aca_disqo_generactive.utils.ApplicationContext;

public class MockDataHelper {

    private static GroupService groupService = new ApplicationContext().getGroupService();
    private static ItemService itemService = new ApplicationContext().getItemService();

    public static void run(){
        GroupDTO group = new GroupDTO(1,0,"Root");
        GroupDTO group1 = new GroupDTO(2,1,"SubRoot");
        ItemDTO itemDTO = new ItemDTO(1,100,"AMD",2,1);
        System.out.println(itemService.create(itemDTO));
    }
}
