package repository.model;

import java.util.List;

public class Group {

    private int id;
    private String name;
    private int parentGroup;
    private List<Group> subGroups;
    private List<Item> items;

    public Group() {
    }

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Group(int id, String name, int parentGroup) {
        this.id = id;
        this.name = name;
        this.parentGroup = parentGroup;
    }

    public Group(int id, String name, List<Group> subGroups, List<Item> items) {
        this.id = id;
        this.name = name;
        this.subGroups = subGroups;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(int parentGroup) {
        this.parentGroup = parentGroup;
    }

    public List<Group> getSubGroups() {
        return subGroups;
    }

    public void setSubGroups(List<Group> subGroups) {
        this.subGroups = subGroups;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentGroup=" + parentGroup +
                ", subGroups=" + subGroups +
                ", items=" + items +
                '}';
    }
}
