package repository.container;

import repository.model.Group;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static List<Group> groups = new ArrayList<>();

    public static Group saveToDatabase(final Group group) {
        groups.add(group);
        return groups.stream().filter(group1 -> group1.getId() == group.getId()).findFirst().get();
    }

    public static List<Group> getGroupList() {
        return groups;
    }
}
