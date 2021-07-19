package controller;

import controller.dto.GroupDTO;
import repository.model.Group;
import service.GroupService;
import service.impl.GroupServiceImpl;

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
