package com.aca_disqo_generactive.converter;

import com.aca_disqo_generactive.controller.dto.GroupDTO;
import com.aca_disqo_generactive.repository.model.Group;

public interface GroupConverter {

    GroupDTO convert(Group group);
}
