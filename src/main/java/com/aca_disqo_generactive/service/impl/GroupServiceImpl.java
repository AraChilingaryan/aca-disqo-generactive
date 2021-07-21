package com.aca_disqo_generactive.service.impl;

import com.aca_disqo_generactive.controller.dto.GroupDTO;
import com.aca_disqo_generactive.repository.container.Database;
import com.aca_disqo_generactive.repository.model.Group;
import com.aca_disqo_generactive.service.GroupService;

public class GroupServiceImpl implements GroupService {

    public GroupServiceImpl() {
    }

    @Override
    public Group create(GroupDTO groupDTO) {
        return Database.saveToDatabase(createGroupFrom(groupDTO));
    }

    @Override
    public Group get(int id) {
        return Database.getGroupList().stream()
                .filter(group -> group.getId() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("No Group by that id"));
    }

    private Group createGroupFrom(GroupDTO groupDTO) {
        final Group group = new Group();
        group.setId(groupDTO.getId());
        group.setName(groupDTO.getName());
        if (groupDTO.getParentId() != 0) {
            Group parentGroup = get(groupDTO.getParentId());
            parentGroup.getSubGroups().add(group);
            group.setParentGroup(parentGroup);
        }
        group.setResolution(groupDTO.getResolution());
        return group;
    }
}
