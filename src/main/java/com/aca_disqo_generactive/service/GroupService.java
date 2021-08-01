package com.aca_disqo_generactive.service;

import com.aca_disqo_generactive.controller.dto.GroupDTO;
import com.aca_disqo_generactive.repository.model.Group;

import java.util.List;

public interface GroupService {

    Group create(GroupDTO groupDTO);

    Group get(int id);

    List<Group> getAll();

    void deleteById(int id);

    Group findGroupByName(String name);

}
