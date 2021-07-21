package com.aca_disqo_generactive.controller;

import com.aca_disqo_generactive.controller.dto.GroupDTO;
import com.aca_disqo_generactive.converter.GroupConverter;
import com.aca_disqo_generactive.service.GroupService;

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

    public GroupDTO get(int id) {
        return groupConverter.convert(this.groupService.get(id));
    }
}
