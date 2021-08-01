package com.aca_disqo_generactive.service.impl;

import com.aca_disqo_generactive.controller.dto.GroupDTO;
import com.aca_disqo_generactive.repository.GroupRepository;
import com.aca_disqo_generactive.repository.model.Group;
import com.aca_disqo_generactive.service.GroupService;
import com.aca_disqo_generactive.utils.ApplicationContext;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    private static GroupService groupService = null;
    private final GroupRepository groupRepository;

    private GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public static GroupService getInstance() {
        if (groupService == null) {
            groupService = new GroupServiceImpl(ApplicationContext.getInstance().getGroupRepository());
        }
        return groupService;
    }

    @Override
    public Group create(GroupDTO groupDTO) {
        return groupRepository.create(createGroupFrom(groupDTO));
    }

    @Override
    public Group get(int id) {
        return groupRepository.get(id);
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.getAll();
    }

    @Override
    public void deleteById(int id) {
        groupRepository.deleteById(id);
    }

    @Override
    public Group findGroupByName(String name) {
        return groupRepository.findGroupByName(name);
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
