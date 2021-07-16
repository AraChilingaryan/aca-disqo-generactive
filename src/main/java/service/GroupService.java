package service;

import repository.model.Group;
import repository.model.Item;

import java.util.List;
import java.util.stream.Collectors;

public class GroupService {

    private List<Group> groups;
    private List<Item> items;

    public GroupService() {
    }

    public GroupService(final List<Group> groups, List<Item> items) {
        this.groups = groups;
        this.items = items;
    }

    public List<Group> createFinalGroups(final List<Group> groups, final List<Item> items){
        final List<Group> setGroups = setSubGroupsForParentGroups(groups);
        final List<Group> finalGroups = setItemsForGroups(setGroups, items);
        return finalGroups;
    }

    public  List<Group> setItemsForGroups(final List<Group> groups,  final List<Item> items) {
        groups.forEach(group -> {
            group.setItems(items.stream().filter(item -> item.getGroupId() == group.getId())
                    .collect(Collectors.toList()));
        });
        return groups;
    }


    public  List<Group> setSubGroupsForParentGroups(final List<Group> groups) {
        groups.stream().filter(group -> group.getParentGroup() == 0).forEach(group -> {
            List<Group> subGroups = groups.stream().filter(group1 -> group1.getParentGroup() == group.getId())
                    .collect(Collectors.toList());
            group.setSubGroups(subGroups);
        });
        return groups;
    }
}
