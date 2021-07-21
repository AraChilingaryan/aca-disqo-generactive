package com.aca_disqo_generactive;

import com.aca_disqo_generactive.controller.GroupController;
import com.aca_disqo_generactive.controller.ItemController;
import com.aca_disqo_generactive.controller.dto.GroupDTO;
import com.aca_disqo_generactive.controller.dto.ItemDTO;
import com.aca_disqo_generactive.service.GroupService;
import com.aca_disqo_generactive.service.ItemService;
import com.aca_disqo_generactive.utils.ApplicationContext;
import com.aca_disqo_generactive.utils.Resolution;

public class MockDataHelper {
    ApplicationContext applicationContext = new ApplicationContext();
    private static GroupController groupController = new ApplicationContext().getGroupController();
    private static ItemController itemController = new ApplicationContext().getItemController();

    public static void run() {
        GroupDTO group = new GroupDTO(1, 0, "Root");
        GroupDTO group1 = new GroupDTO(2, 1, "SubRoot");
        ItemDTO itemDTO = new ItemDTO(1, 100, "AMD", 2, 2);
        itemDTO.setResolution(Resolution.FHD);
        System.out.println(groupController.create(group));
        System.out.println(groupController.create(group1));
        System.out.println(itemController.create(itemDTO));
        System.out.println(groupController.get(2));
        System.out.println(groupController.get(1));
    }
}
