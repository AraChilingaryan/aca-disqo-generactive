package com.aca_disqo_generactive.service;

import com.aca_disqo_generactive.controller.dto.GroupDTO;
import com.aca_disqo_generactive.repository.model.Group;

public interface GroupService {

    Group create(GroupDTO groupDTO);

    Group get(int id);
}
