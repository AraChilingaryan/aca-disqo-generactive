package com.aca_disqo_generactive.controller;

import com.aca_disqo_generactive.controller.dto.GroupDTO;
import com.aca_disqo_generactive.converter.GroupConverter;
import com.aca_disqo_generactive.repository.model.Group;
import com.aca_disqo_generactive.service.GroupService;

import java.util.List;

public class GroupController {

    private final GroupService groupService;
    private final GroupConverter groupConverter;

    public GroupController(GroupService groupService, GroupConverter groupConverter) {
        this.groupService = groupService;
        this.groupConverter = groupConverter;
    }

    public GroupDTO create(GroupDTO groupDTO) {
        return groupConverter.convert(this.groupService.create(groupDTO));
    }

    public Group get(int id) {
        return this.groupService.get(id);
    }

    public List<Group> getAll() {
        return groupService.getAll();
    }

    public void deleteById(int id) {
        groupService.deleteById(id);
    }

    public Group findGroupByName(String name) {
        return groupService.findGroupByName(name);
    }
}
