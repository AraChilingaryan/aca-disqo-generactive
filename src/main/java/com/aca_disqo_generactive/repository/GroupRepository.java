package com.aca_disqo_generactive.repository;

import com.aca_disqo_generactive.repository.model.Group;

import java.util.List;

public interface GroupRepository {

    Group create(Group group);

    Group get(int id);

    List<Group> getAll();

    void deleteById(int id);

    Group findGroupByName(String name);

}
