package com.aca_disqo_generactive.controller;

import com.aca_disqo_generactive.controller.dto.GroupDTO;
import com.aca_disqo_generactive.repository.model.Group;
import com.aca_disqo_generactive.service.GroupService;
import com.aca_disqo_generactive.service.impl.GroupServiceImpl;

public class GroupController {

    private final GroupService groupService;

    public GroupController() {
        this.groupService = new GroupServiceImpl();
    }

    public Group create(GroupDTO groupDTO){
       return this.groupService.create(groupDTO);
    }

    public Group get(int id){
        return this.groupService.get(id);
    }
}
