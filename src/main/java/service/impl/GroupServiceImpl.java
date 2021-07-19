package service.impl;

import controller.dto.GroupDTO;
import repository.container.Database;
import repository.model.Group;
import service.GroupService;

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
                .findAny().orElseThrow(() -> new RuntimeException("No Group by that id"));
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
        return group;
    }
}
