package service;

import controller.dto.GroupDTO;
import repository.model.Group;
import repository.model.Item;

import java.util.List;

public interface GroupService {

    Group create(GroupDTO groupDTO);

    Group get(int id);
}
